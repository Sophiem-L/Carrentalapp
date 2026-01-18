<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

use App\Models\Booking;

class BookingController extends Controller
{
    protected $firestore;
    protected $collection;

    public function __construct()
    {
        $this->firestore = app('firebase.firestore')->database();
        $this->collection = $this->firestore->collection('bookings');
    }

    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\JsonResponse
     */
    public function index()
    {
        $documents = $this->collection->documents();
        $bookings = [];
        foreach ($documents as $document) {
            if ($document->exists()) {
                $bookings[] = array_merge(['id' => $document->id()], $document->data());
            }
        }
        return response()->json($bookings);
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
            'car_id' => 'required|string', // Firestore IDs are strings
            'user_name' => 'required|string',
            'user_email' => 'required|email',
            'start_date' => 'required|date',
            'end_date' => 'required|date|after_or_equal:start_date',
            'total_price' => 'required|integer',
        ]);

        $validated['status'] = 'pending';
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
            return response()->json(['message' => 'Booking not found'], 404);
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
            return response()->json(['message' => 'Booking not found'], 404);
        }

        $docRef->set($request->all(), ['merge' => true]);
        return response()->json(['message' => 'Booking updated']);
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
            return response()->json(['message' => 'Booking not found'], 404);
        }

        $docRef->delete();
        return response()->json(['message' => 'Booking deleted']);
    }
}
