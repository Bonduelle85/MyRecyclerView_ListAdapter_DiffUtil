package com.example.myrecyclerviewlistadapterdiffutil

class PetData {
    val petList = mutableListOf(
        Cat("Barsic", R.drawable.cat_1, 5),
        Cat("Mursic", R.drawable.cat_2, 12),
        Cat("Mashka", R.drawable.cat_3, 10),
        Cat("Muska", R.drawable.cat_4, 4),
        Cat("Liza", R.drawable.cat_5, 9),
        Cat("Patric", R.drawable.cat_6, 4),
        Cat("Lion", R.drawable.cat_7, 3),
        Cat("Liza", R.drawable.cat_8, 1),
        Cat("Monk", R.drawable.cat_9, 2),
        Cat("Kesha", R.drawable.cat_10, 7),
        Cat("Marci", R.drawable.cat_11, 9),
        Cat("Lex", R.drawable.cat_12, 3),
        Cat("Barsic", R.drawable.cat_1, 5),
        Cat("Mursic", R.drawable.cat_2, 12),
        Cat("Mashka", R.drawable.cat_3, 10),
        Cat("Muska", R.drawable.cat_4, 4),
        Cat("Liza", R.drawable.cat_5, 9),
        Cat("Patric", R.drawable.cat_6, 4),
        Dog("Dog", R.drawable.dog_1, 3),
        Dog("Marshal", R.drawable.dog_2, 1),
        Dog("Tuzic", R.drawable.dog_3, 4),
        Dog("Tor", R.drawable.dog_3, 4),
        Dog("Luk", R.drawable.dog_4, 1),
        Dog("Leila", R.drawable.dog_5, 1),
        Dog("Penny", R.drawable.dog_6, 12),
        Dog("Lara", R.drawable.dog_7, 5),
        Dog("Ken", R.drawable.dog_8, 7),
        Dog("Boss", R.drawable.dog_4, 9),
    ).also { it.shuffle() }
}