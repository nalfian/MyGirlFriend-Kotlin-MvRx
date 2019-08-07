@file:Suppress("Detekt.MaxLineLength")

package com.nalfian.mygirlfriend.data

import io.reactivex.Observable
import io.reactivex.Single

class MyGirlFriendRepository {
    fun getDogs() = Observable.fromCallable<List<MyGirlFriend>> {
        Thread.sleep(2000)
        listOf(
            MyGirlFriend(
                44365525,
                "Shin Min Ah",
                "https://palingunik85.files.wordpress.com/2017/09/a0021.jpg",
                "Artis Korea tercantik yang tidak pernah melakukan operasi plastik pertama yaitu Shin Min Ah. Bagi pengemar drama Korea, tentunya sudah tidak asing lagi dengan nama artis kelahiran tanggal 5 April 1984 ini.\n" +
                        "\n" +
                        "Wajah cantik dan lesung pipit khasnya tersebut, disebut-sebut oleh para pengemarnya memang asli, dan bukan hasil operasi plastik. Hal ini bisa dibuktikan dengan melihat foto-foto masa kecilnya, yang memang sudah cantik sejak dulu.\n" +
                        "\n" +
                        "Shin Min Ah mulai terjun ke dunia hiburan sebagai model di majalah remaja ” Kiki “ pada tahun 1998 silam. Namanya semakin dikenal publik di Korea Selatan setelah membintangi drama Korea berjudul ” My Girl Friend is Gumiho “\n"
            ),
            MyGirlFriend(
                40037002,
                "Song Hye Kyo",
                "https://palingunik85.files.wordpress.com/2017/09/a0022.jpg",
                "Artis Korea tercantik selanjutnya yang juga tidak pernah melakukan operasi plastik yaitu Song Hye Kyo. Hal ini bisa dibuktikan dari foto-foto masa lalunya, yang tetap cantik hingga sekarang, walaupun usianya kini sudah melewati kepala tiga.\n" +
                        "Bahkan, berkat kecantikannya tersebut, bisa membawa artis kelahiran 22 November 1981 silam ini, masuk ke daftar 100 wanita tercantik di dunia. Wow…\n" +
                        "Namanya mulai dikenal publik Korea Selatan setelah dia membintangi serial drama Korea berjudul ” Full House “. Setelah itu, nama Song Hye Kyo semakin terkenal dan memiliki banyak sekali fans di dunia.\n" +
                        "\n"
            ),
            MyGirlFriend(
                39936816,
                "Han Ga In",
                "https://palingunik85.files.wordpress.com/2017/09/a0023.jpg",
                "Artis kelahiran 25 Februari 1982 ini mengaku tidak pernah melakukan operasi plastik, dimana kecantikan yang dimiliki sekarang adalah hasil dari perawatan yang sering dilakukannya sejak dia masih belia dulu.\n" +
                        "Nama Han Ga In mulai dikenal setelah sukses membintangi serial TV berjudul ” Yellow Handkerchief “ dan ” Tterms of Endearment “. Diketahui juga, kalau Han Ga In ini adalah salah satu pengemar berat leader Big Bang yakni G-Dragon.\n" +
                        "\n"
            ),
            MyGirlFriend(
                40379134,
                "Kim Tae Hee",
                "https://palingunik85.files.wordpress.com/2017/09/a0024.jpg",
                "Siapa yang tidak tahu dengan salah satu artis Korea tercantik yang satu ini, dimana kecantikannya lewat beberapa drama Korea populer, berhasil membuatnya mempunyai banyak fans di seluruh dunia, khususnya di negara-negara Asia.\n" +
                        "Banyak pengemarnya yang mengatakan bahwa, kecantikan yang dimiliki oleh Kim Tae Hee, bukanlah hasil dari operasi plastik. Kecantikannya pun tidak pernah luntur, walaupun kini usianya sudah mencapai 37 tahun.\n" +
                        "\n"
            ),
            MyGirlFriend(
                40706214,
                "Im Yoona",
                "https://palingunik85.files.wordpress.com/2017/09/a0025.jpg",
                "Im Yoona adalah salah satu anggota girlband SNSD (Girl Generation), yang sudah membintangi beberapa serial TV Korea. Wajahnya yang cantik dan lugu ini adalah kecantikan alami yang tidak pernah disentuh oleh pisau bedah operasi plastik.\n" +
                        "Bisa dikatakan, artis kelahiran 30 Mei 1990 ini adalah salah satu wanita idaman pria di dunia. Drama Korea yang pernah dibintanginya di antaranya yaitu ” Cinderella Man “, ” Love Rain “, dan ” Prime Minister and I “.\n" +
                        "\n"
            )
        )
    }

    fun meetGirlFriend(myGirlFriend: MyGirlFriend) = Single.fromCallable {
        Thread.sleep(2000)
        myGirlFriend
    }
}