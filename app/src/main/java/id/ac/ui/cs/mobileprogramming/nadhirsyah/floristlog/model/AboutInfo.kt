package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "about_table")
data class AboutInfo (
    @PrimaryKey
    val id : Int,
    val body : String
)