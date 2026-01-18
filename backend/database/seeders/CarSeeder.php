<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;

class CarSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        \App\Models\Car::create([
            'brand' => 'Tesla',
            'model' => 'Model 3',
            'type' => 'Electric',
            'price_per_day' => 150,
            'description' => 'A fast and efficient electric car.',
            'is_available' => true,
        ]);

        \App\Models\Car::create([
            'brand' => 'Toyota',
            'model' => 'Camry',
            'type' => 'Sedan',
            'price_per_day' => 80,
            'description' => 'Reliable and comfortable sedan.',
            'is_available' => true,
        ]);
    }
}
