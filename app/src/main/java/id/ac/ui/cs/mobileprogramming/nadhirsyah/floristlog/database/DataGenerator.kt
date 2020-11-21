package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.database

import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Flower

class DataGenerator {
    companion object{
        fun getFlower() : List<Flower>{
            return listOf(
                Flower(1, "Bunga Standing", "Rp600.000","https://res.cloudinary.com/dirda1899/image/upload/v1605894937/637bc275-f487-4f47-a1ab-d9be7d97d259_iclr1u.jpg"),
                Flower(2, "Bunga Papan Ukuran Sedang", "Rp800.000","https://res.cloudinary.com/dirda1899/image/upload/v1605894946/c0d146c1-1324-4855-95a7-b1cc81290cb5_ru5jfe.jpg") ,
                Flower(3, "Bunga Papan Ukuran Besar", "Rp1.000.000","https://res.cloudinary.com/dirda1899/image/upload/v1605894937/9f1cb9a2-d08b-4514-bdd1-3e4a4ddacdd9_xyee0f.jpg"),
                Flower(4, "Bunga Papan Ukuran Standard", "Rp600.000","https://res.cloudinary.com/dirda1899/image/upload/v1605894939/c99b8351-8c9e-42c5-81a9-2de2d47dc344_fmasnu.jpg"),

            )
        }
    }

}