<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::get('/', function () {
    return response()->json(['message' => 'Car Rental API is running. Try /api/cars or /api/bookings']);
});

Route::get('/test-firebase', function () {
    try {
        $firestore = app('firebase.firestore');
        $database = $firestore->database();
        return response()->json(['message' => 'Firebase connection successful!', 'project' => $database->name()]);
    } catch (\Exception $e) {
        return response()->json(['error' => $e->getMessage()], 500);
    }
});

use App\Http\Controllers\Api\CarController;
use App\Http\Controllers\Api\BookingController;

Route::apiResource('cars', CarController::class);
Route::apiResource('bookings', BookingController::class);

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});
