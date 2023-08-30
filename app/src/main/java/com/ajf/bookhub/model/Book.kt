package com.ajf.bookhub.model

data class Book(
    val bookId: String,
    val bookName: String,
    val bookAuthor: String,
    val bookPrice: String,
    val bookRating: String,
    val bookCover: String
)

//val bookInfoList = arrayListOf(
//    Book("Hello Kitty", "Julian", "Rs. 699", "4.8", R.drawable.anna_kare),
//    Book("My Dreams", "X", "Rs. 1099", "4.0", R.drawable.adventures_finn),
//    Book("Lock n Love", "Robert R.J", "Rs. 300", "3.2", R.drawable.great_gatsby),
//    Book("The Spirits Call me", "Betty", "Rs. 450", "4.8", R.drawable.lolita),
//    Book("Legends Of Tomorrow", "J.R.R. Tolkien", "Rs. 2599", "4.5", R.drawable.lord_of_rings),
//    Book("Night Sky", "Samuel LK", "Rs. 299", "2.8", R.drawable.madame),
//    Book("Rainbow Rides", "Richard Rich", "Rs. 10000", "5.0", R.drawable.middlemarch),
//    Book("Lucrative Decision", "Mr. Unknown", "Rs. 6969", "4.9", R.drawable.moby_dick),
//    Book("Harry Potter", "J.K Rowling", "Rs. 699", "4.8", R.drawable.ps_ily),
//    Book("Twilight", "Stephenie Meyer", "Rs. 699", "4.8", R.drawable.war_and_peace)
//)
