package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.AboutInfo
@Dao
interface AboutInfoDAO {
    @Insert
    fun insert(about: AboutInfo)

    @Query("SELECT * FROM about_table WHERE id = :id")
    fun getAboutInfo(id: Int): AboutInfo
}