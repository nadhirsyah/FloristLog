package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flower_table")
data class Flower(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    val id: Int,
    @ColumnInfo(name="name")
    val name: String,
    @ColumnInfo(name="price")
    val price: String,
    @ColumnInfo(name="img_link")
    val img_link: String
)