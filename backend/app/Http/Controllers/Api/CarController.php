<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

use App\Models\Car;
use Kreait\Laravel\Firebase\Facades\Firebase;

class CarController extends Controller
{
    protected $firestore;
    protected $collection;

    public function __construct()
    {
        $this->firestore = app('firebase.firestore')->database();
        $this->collection = $this->firestore->collection('cars');
    }

    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\JsonResponse
     */
    public function index()
    {
        $documents = $this->collection->where('is_available', '=', true)->documents();
        $cars = [];
        foreach ($documents as $document) {
            if ($document->exists()) {
                $cars[] = array_merge(['id' => $document->id()], $document->data());
            }
        }
        return response()->json($cars);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\JsonResponse
     */
    public function store(Request $request)
    {
        $validated = $request->validate([
            'brand' => 'required|string',
            'model' => 'required|string',
            'type' => 'required|string',
            'price_per_day' => 'required|integer',
            'image_url' => 'nullable|string',
            'description' => 'nullable|string',
        ]);

        $validated['is_available'] = true;
        $docRef = $this->collection->add($validated);

        return response()->json(array_merge(['id' => $docRef->id()], $validated), 201);
    }

    /**
     * Display the specified resource.
     *
     * @param  int|string  $id
     * @return \Illuminate\Http\JsonResponse
     */
    public function show($id)
    {
        $docRef = $this->collection->document($id);
        $snapshot = $docRef->snapshot();

        if (!$snapshot->exists()) {
            return response()->json(['message' => 'Car not found'], 404);
        }

        return response()->json(array_merge(['id' => $snapshot->id()], $snapshot->data()));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int|string  $id
     * @return \Illuminate\Http\JsonResponse
     */
    public function update(Request $request, $id)
    {
        $docRef = $this->collection->document($id);
        if (!$docRef->snapshot()->exists()) {
            return response()->json(['message' => 'Car not found'], 404);
        }

        $docRef->set($request->all(), ['merge' => true]);
        return response()->json(['message' => 'Car updated']);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int|string  $id
     * @return \Illuminate\Http\JsonResponse
     */
    public function destroy($id)
    {
        $docRef = $this->collection->document($id);
        if (!$docRef->snapshot()->exists()) {
            return response()->json(['message' => 'Car not found'], 404);
        }

        $docRef->delete();
        return response()->json(['message' => 'Car deleted']);
    }
}
