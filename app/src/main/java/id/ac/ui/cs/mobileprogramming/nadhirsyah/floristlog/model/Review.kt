package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "review_table",
    foreignKeys = arrayOf(
        ForeignKey(entity = Flower::class, parentColumns = arrayOf("id"),
            childColumns = arrayOf("flowerId"),
            onDelete = ForeignKey.CASCADE)
        ))
data class Review(
    @ColumnInfo(name="text")
    val text: String,
    @ColumnInfo(name="flowerId")
    val flowerID: String,
    val imageUri:String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)