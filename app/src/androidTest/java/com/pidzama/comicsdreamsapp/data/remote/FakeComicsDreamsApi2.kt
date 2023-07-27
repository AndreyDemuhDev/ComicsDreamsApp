package com.pidzama.comicsdreamsapp.data.remote

import com.pidzama.comicsdreamsapp.domain.model.ApiResponse
import com.pidzama.comicsdreamsapp.domain.model.Hero
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.BATMAN
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.BATWOMAN
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.CATWOMAN
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.DAREDEVIL
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.DEATHSTROKE
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.DONATELLO
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.FLASH
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.GREEN_LANTERN
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.HARLEY_QUINN
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.HELLBOY
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.HULK
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.IRON_MAN
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.JOKER
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.NIGHTWING
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.PUNISHER
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.RAVEN
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.SPIDER_MAN
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.SUPERMAN
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.WOLVERINE
import com.pidzama.comicsdreamsapp.util.Constants.BIOGRAPHY.WONDER_WOMAN
import com.pidzama.comicsdreamsapp.util.Constants.Page.NEXT_PAGE_KEY
import com.pidzama.comicsdreamsapp.util.Constants.Page.PREVIOUS_PAGE_KEY
import java.io.IOException

class FakeComicsDreamsApi2 : ComicsDreamsApi {

    private val heroes: Map<Int, List<Hero>> by lazy {
        mapOf(
            1 to page1,
            2 to page2,
            3 to page3,
            4 to page4,
            5 to page5,
        )
    }
    private var page1 = listOf(
        Hero(
            id = 1,
            alias = "Batman",
            realName = "Bruce Wayne",
            image = "/images/batman.jpg",
            biography = BATMAN,
            position = "Good",
            height = 1.88,
            power = 91,
            rating = 4.8,
            allies = listOf("Robin", "James Gordon", "Batgirl", "Catwoman"),
            enemies = listOf("Joker", "The Riddler", "Harley Quinn", "Deadshot"),
            publisher = "DC Comics"
        ),
        Hero(
            id = 2,
            alias = "Spider-Man",
            realName = "Peter Benjamin Parker",
            image = "/images/spider_man.jpg",
            biography = SPIDER_MAN,
            position = "Good",
            height = 1.72,
            power = 92,
            rating = 4.9,
            allies = listOf("Iron Man", "Dr. Strange", "Deadpool", "Hulk"),
            enemies = listOf("Green Goblin", "Doctor Octopus", "Carnage ", "Mysterio"),
            publisher = "Marvel"
        ),
        Hero(
            id = 3,
            alias = "Wolverine",
            realName = "James «Jimmy» Howlett",
            image = "/images/wolverine.jpg",
            biography = WOLVERINE,
            position = "Good",
            height = 1.76,
            power = 89,
            rating = 4.6,
            allies = listOf("Professor X", "Storm", "Cyclops", "Captain America"),
            enemies = listOf("Magneto", "Lady Deathstrike", "Sabretooth", "Mystique"),
            publisher = "Marvel"
        ),
        Hero(
            id = 4,
            alias = "Jocker",
            realName = "Unknown",
            image = "/images/joker.jpg",
            biography = JOKER,
            position = "Evil",
            height = 1.95,
            power = 86,
            rating = 4.6,
            allies = listOf("The Riddler", "Two-Face", "«Lex» Luthor"),
            enemies = listOf("Batman", "Nightwing", "Batgirl", "Catwoman"),
            publisher = "DC Comics"
        )
    )
    private var page2 = listOf(
        Hero(
            id = 5,
            alias = "Iron Man",
            realName = "Anthony Edward \"Tony\" Stark",
            image = "/images/iron_man.jpg",
            biography = IRON_MAN,
            position = "Good",
            height = 1.89,
            power = 83,
            rating = 4.6,
            allies = listOf("War Machine", "Hulk", "Thor", "Dr.Strange", "Vision"),
            enemies = listOf("Mandarin", "Whiplash", "Dormammu", "M.O.D.O.K"),
            publisher = "Marvel"
        ),
        Hero(
            id = 6,
            alias = "Catwoman",
            realName = "Selina Kyle",
            image = "/images/cat_woman.jpg",
            biography = CATWOMAN,
            position = "Good",
            height = 1.70,
            power = 74,
            rating = 3.9,
            allies = listOf("Batman", "Poison Ivy", "Harley Quinn", "The Riddler"),
            enemies = listOf("Joker", "Black Mask", "Two-Face", "Penguin", "Bane "),
            publisher = "DC Comics"
        ),
        Hero(
            id = 7,
            alias = "Hellboy",
            realName = "Anung Un Rama",
            image = "/images/hellboy.jpg",
            biography = HELLBOY,
            position = "Good",
            height = 1.95,
            power = 90,
            rating = 4.4,
            allies = listOf("Эйб Сапиен", "Лиз Шерман", "Роджер"),
            enemies = listOf("Огру Джахад", "Распутин"),
            publisher = "Dark Horse Comics"
        ),
        Hero(
            id = 8,
            alias = "Donatello",
            realName = "Donatello",
            image = "/images/donatello.jpg",
            biography = DONATELLO,
            position = "Good",
            height = 1.76,
            power = 80,
            rating = 4.4,
            allies = listOf("Splinter", "Hamato Yoshi", "April O’Neil", "«Casey» Jones"),
            enemies = listOf("Shredder", "Dr.Baxter Stockman", "Krang", "Bebop", "Rocksteady"),
            publisher = "Mirage Studios"
        ),

        )
    private var page3 = listOf(
        Hero(
            id = 9,
            alias = "Deathstroke",
            realName = "Slade Joseph Wilson",
            image = "/images/deathstroke.jpg",
            biography = DEATHSTROKE,
            position = "Evil",
            height = 1.93,
            power = 79,
            rating = 4.1,
            allies = listOf("Deadshot", "Green Arrow", "Alexander Joseph «Lex» Luthor"),
            enemies = listOf("Batman", "Nightwing", "Ra’s al Ghul", "Green Arrow"),
            publisher = "DC Comics"
        ),
        Hero(
            id = 10,
            alias = "Batwoman",
            realName = "Katherine \"Kate\" Kane",
            image = "/images/batwoman.jpg",
            biography = BATWOMAN,
            position = "Good",
            height = 1.73,
            power = 82,
            rating = 3.8,
            allies = listOf("Batman", "Robin", "Nightwing ", "Batgirl", "Flash", "Superman"),
            enemies = listOf("Joker", "Two-Face", "Riddler", "Penguin"),
            publisher = "DC Comics"
        ),
        Hero(
            id = 11,
            alias = "Wonder Woman",
            realName = "Diana",
            image = "/images/wonder_woman.jpg",
            biography = WONDER_WOMAN,
            position = "Good",
            height = 1.82,
            power = 96,
            rating = 4.2,
            allies = listOf("Batman", "Superman", "Green Lantern", "Flash", "Aquaman"),
            enemies = listOf("Ares", "Cheetah", "Vandal Savage", "Darkseid"),
            publisher = "DC Comics"
        ),
        Hero(
            id = 12,
            alias = "Superman",
            realName = "Clark Kent",
            image = "/images/superman.jpg",
            biography = SUPERMAN,
            position = "Good",
            height = 1.97,
            power = 98,
            rating = 4.8,
            allies = listOf("Batman", "Wonder Woman", "Green Lantern", "Flash", "Aquaman"),
            enemies = listOf("«Lex» Luthor", "Metallo", "Parasite", "Doomsday", "Hank Henshaw"),
            publisher = "DC Comics"
        )
    )
    private var page4 = listOf(
        Hero(
            id = 13,
            alias = "Raven",
            realName = "Rachel Roth",
            image = "/images/raven.jpg",
            biography = RAVEN,
            position = "Good",
            height = 1.67,
            power = 79,
            rating = 3.6,
            allies = listOf("John Constantine", "Superman", "Starfire"),
            enemies = listOf("Trigon", "Deathstroke"),
            publisher = "DC Comics"
        ),
        Hero(
            id = 14,
            alias = "Daredevil",
            realName = "Matthew Michael Murdock",
            image = "/images/daredevil.jpg",
            biography = DAREDEVIL,
            position = "Good",
            height = 1.83,
            power = 81,
            rating = 4.5,
            allies = listOf("Spider-man", "Elektra Natchios", "Punisher"),
            enemies = listOf("Kingpin", "Bullseye", "Doctor Victor von Doom"),
            publisher = "Marvel Comics"
        ),
        Hero(
            id = 15,
            alias = "Harley Quinn",
            realName = "Harleen Frances Quinzel",
            image = "/images/harley_quinn.jpg",
            biography = HARLEY_QUINN,
            position = "Evil",
            height = 1.70,
            power = 78,
            rating = 4.7,
            allies = listOf("Poison Ivy", "Deadshot", "Power Girl", "Catwoman", "Batman", "Joker"),
            enemies = listOf("Batman", "Joker", "Nightwing ", "Black Mask", "Hush"),
            publisher = "DC Comics"
        ),
        Hero(
            id = 16,
            alias = "Green Lantern",
            realName = "Harold «Hal» Jordan",
            image = "/images/green_lantern.jpg",
            biography = GREEN_LANTERN,
            position = "Good",
            height = 1.82,
            power = 83,
            rating = 3.9,
            allies = listOf("Batman", "Green Arrow", "Wonder woman", "Flash ", "Superman"),
            enemies = listOf(
                "Agent Orange",
                "Sinestro Corps",
                "Red Lantern Corps",
                "Black Lantern Corps"
            ),
            publisher = "DC Comics"
        ),
    )
    private var page5 = listOf(
        Hero(
            id = 17,
            alias = "Punisher",
            realName = "Francis «Frank» Castle",
            image = "/images/punisher.jpg",
            biography = PUNISHER,
            position = "Good",
            height = 1.86,
            power = 71,
            rating = 3.8,
            allies = listOf("Daredevil", "Spider-Man", "Captain America", "Elektra Natchios"),
            enemies = listOf("Kingpin", "Jigsaw", "Bushwacker"),
            publisher = "Marvel"
        ),
        Hero(
            id = 18,
            alias = "HULK",
            realName = "Dr.Robert Bruce Banner",
            image = "/images/hulk.jpg",
            biography = HULK,
            position = "Good",
            height = 1.74,
            power = 98,
            rating = 4.8,
            allies = listOf(
                "She-Hulk",
                "Elizabeth \"Betty\" Ross",
                "Rick Jones",
                "Iron Man",
                "Captain America",
                "Thor"
            ),
            enemies = listOf(
                "The Leader",
                "Abomination",
                "General Thaddeus \"Thunderbolt\" Ross",
                "Juggernaut",
                "Doctor Victor von Doom"
            ),
            publisher = "Marvel"
        ),
        Hero(
            id = 19,
            alias = "Flash",
            realName = "Bartholomew Henry Allen",
            image = "/images/flash.jpg",
            biography = FLASH,
            position = "Good",
            height = 1.83,
            power = 79,
            rating = 4.5,
            allies = listOf(
                "Superman",
                "Batman",
                "Wonder Woman",
                "Harold \"Hal\" Jordan",
                "Aquaman",
                "Martian Manhunter"
            ),
            enemies = listOf(
                "Zoom",
                "Shade",
                "Fiddler"
            ),
            publisher = "DC Comics"
        ),
        Hero(
            id = 20,
            alias = "Nightwing",
            realName = "Dick Grayson",
            image = "/images/nightwing.jpg",
            biography = NIGHTWING,
            position = "Good",
            height = 1.76,
            power = 76,
            rating = 3.5,
            allies = listOf("Batman", "Batwoman", "Batgirl", "Superman"),
            enemies = listOf("Joker", "Two-Face", "Penguine", "Bane", "Deathstroke"),
            publisher = "DC Comics"
        ),
    )

    private var exception = false

    private fun calculatePage(page: Int): Map<String, Int?> {
        if (page1.isEmpty()) {
            return mapOf(PREVIOUS_PAGE_KEY to null, NEXT_PAGE_KEY to null)
        }
        var prevPage: Int? = page
        var nextPage: Int? = page
        if (page in 1..4) {
            nextPage = nextPage?.plus(1)
        }
        if (page in 2..5) {
            prevPage = prevPage?.minus(1)
        }
        if (page == 1) {
            prevPage = null
        }
        if (page == 5) {
            nextPage = null
        }
        return mapOf(PREVIOUS_PAGE_KEY to prevPage, NEXT_PAGE_KEY to nextPage)
    }

    fun clearData() {
        page1 = emptyList()
    }

    fun addException() {
        exception = true
    }

    override suspend fun getAllHeroes(page: Int): ApiResponse {
        if (exception) {
            throw IOException()
        }
        require(page in 1..5)
        return ApiResponse(
            success = true,
            message = "OK",
            prevPage = calculatePage(page = page)[PREVIOUS_PAGE_KEY],
            nextPage = calculatePage(page = page)[NEXT_PAGE_KEY],
            heroes = heroes[page]!!
        )
    }

    override suspend fun searchHeroes(name: String): ApiResponse {
        return ApiResponse(
            success = false
        )
    }
}