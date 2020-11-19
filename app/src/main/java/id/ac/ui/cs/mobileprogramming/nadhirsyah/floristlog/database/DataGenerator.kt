package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.database

import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Flower

class DataGenerator {
    companion object{
        fun getFlower() : List<Flower>{
            return listOf(
                Flower(1, "Mawar", "10","https://res.cloudinary.com/dirda1899/image/upload/v1597486331/50JIWA_2_1596679948.jpg"),
                Flower(2, "Melati", "10","https://res.cloudinary.com/dirda1899/image/upload/v1597486331/50JIWA_2_1596679948.jpg")
            )
        }
    }

}