package com.pidzama.comicsdreamsapp.util

object Constants {

    const val DETAIL_ARGUMENT_KEY = "heroId"
    const val HERO_DATABASE_TABLE_NAME = "hero_table"
    const val HERO_REMOTE_SERVER_DATABASE_TABLE_NAME = "hero_remote_server_table"
    const val NAME_HERO_DATABASE = "hero_database"
    const val PREFERENCES_NAME = "comics_dreams_preferences"
    const val PREFERENCES_KEY = "on_boarding_showed"
    const val BASE_URL = "http://10.0.2.2:8080"
    const val ITEMS_PER_PAGE = 4
    const val MAX_LINES_TEXT_BIOGRAPHY = 7
    const val MIN_IMAGE_HERO_DETAILS = 0.4f

    object Page {
        const val NEXT_PAGE_KEY = "nextKey"
        const val PREVIOUS_PAGE_KEY = "prevKey"
    }

    object BIOGRAPHY {
        const val BATMAN =
            "Бэтмен — тайное альтер-эго миллиардера Брюса Уэйна, успешного промышленника, филантропа и справедливого мужчины. В детстве, став свидетелем убийства своих родителей, Брюс поклялся посвятить свою жизнь искоренению преступности и борьбе за справедливость. Подготовив себя физически и морально, он надевает стилизованный костюм летучей мыши и выходит на улицы города для противостояния преступникам."
        const val SPIDER_MAN =
            "Питер Паркер представлялся как одарённый в науке подросток-сирота, который живёт со своими дядей и тётей в Форест-Хилс, Куинс, Нью-Йорк. Питер — отличник, из-за чего подвергается насмешкам сверстников, зовущих его «книжным червём». Во время научной выставки его случайно кусает подопытный радиоактивный паук. Благодаря этому он получает «паучьи» сверхспособности — такие как, например, суперсилу, способность передвигаться по стенам и феноменальную прыгучесть. Пользуясь своими научными знаниями, Питер сконструировал устройство, которое крепится к его запястьям и позволяет «выстреливать» паутиной. Питер скрывает свое имя и внешность под костюмом и маской с символикой паука. Испытывая эйфорию от новых возможностей, Питер начинает бороться с преступностью и становится героем газетных заголовков."
        const val CARNAGE =
            "Загдочный организм называемый симбиотом, который образует симбиотическую связь со своими носителями и наделяют их сверхчеловеческими способностями. Карнаж, является сыном Венома, и считается намного мощнее своего родителя благодаря биологии симбиотов и во многом является его более мрачной версией. Обычно изображается противником Человека-паука, в то же время выступая заклятым врагом Венома. Симбиот имел множество носителей. Оригинальный и самый известный с Земли-616 — это Кле́тус Кэ́седи, серийный убийца из вселенной Marvel, чей садистский характер полностью совпадает с характером симбиота. Среди других известных носителей — Бен Рейли, Карл Малукрин, а также Гвен Стейси"
        const val JOKER =
            "Cамый ярый, неординарный и противоречивый соперник Batman'а. Становится безумцем после падения в чан с кислотой. Он очень жесток, циничен и совершенно непредсказуем. Садист и мазохист. Нельзя не отметить его талант руководителя и организатора, способность собрать вокруг себя команду, которая беспрекословно подчиняется его приказам."
        const val IRON_MAN =
            "Сын богатого промышленника, Тони Старк был гениальным изобретателем и механиком. Он унаследовал бизнес отца в возрасте 21 года, превратив компанию в одного из лидирующих производителей оружия. Старк был ранен осколком в грудь в Азии во время полевого испытание на пригодность боевой брони, которая должна была наделить солдат боевыми способностями. Старка пленил оружейный барон Wong-Chu, вынудив его создать оружие массового поражения - только тогда он получил бы операцию, необходимую для спасения его жизни.Поборов оружейного барона, Старк вернулся в Америку и переконструировал костюм. Выдумав историю, что Железный Человек был его охранником, Старк вступил в двойную жизнь как миллиардер-изобретатель и костюмированный искатель приключений."
        const val CATWOMAN =
            "Селина родилась в одном из беднейших кварталов Готэма. В детстве очень любила рисовать и даже хотела стать художницей. Её мать не очень заботилась о ней и её сестре Мэгги, предпочитая компанию кошек и жизнь в грёзах; она покончила с собой, когда Селине было шесть лет. Ещё через шесть лет умер её отец-алкоголик Брайан Кайл, частенько бивший своих детей. В союзе с Batman'ом стоит на страже порядка в Готем сити "
        const val BANE =
            "Бэйн  - невероятно умный боец мирового класса и гений тактики, который увеличивает свою огромную физическую силу стероидом под названием \"Веном\" (Venom). Отбывая наказание за своего покойного отца, Бейн, настоящее имя которого «Дорранс» ещё ребёнком был посажен в тюрьму Санта Приска. В заключении у него был всего один друг: плюшевый мишка. Став чуть взрослее, Бейн начал читать книги, которые принесли ему тайком в камеру, и заниматься медитацией. Став взрослым, Бейн обрёл духовное равновесие, что и помогло ему выжить во время эксперимента, проводимого с веществом под названием «Веном». В ходе этого эксперимента погибли многие, но Бейн выжил и смог бежать в Готэм. Является одним из ярых противников Betman'а."
        const val DONATELLO =
            "Донателло (или Донни) — один из Черепашек-ниндзя. Является самым могзовитым и разумным в своей команде. Обладает непреодолимой страстью к новым технологиям и техническим приспособлениям. Под воздействием мутагена стал черепахой-мутантом вместе со своими братьми: Леонардо, Микелянджело и Рафаелем. Под руководством крысы мутанта Сплинтера, освоили боевые искусства и стали на тропу борьбы со злом."
        const val SHREDDER =
            "Ороку Саки был младшим братом Ороку Наги, который был убит Хамато Ёси (владельцем Сплинтера, наставника Черепах) в результате ссоры из-за женщины по имени Тэнг Шэн. По этой причине Ёси эмигрировал с Тэнг Шэн в Соединённые Штаты. Потеряв старшего брата, Саки присоединился к клану Фут и обучился боевым искусствам. Со временем он стал одним из сильнейших воинов, который быстро поднялся по внутренней иерархии и был выбран руководителем американского филиала Фут. Обосновавшись в Нью-Йорке под именем Шреддер, став главным противником черепашек-ниндзя"
        const val APRIL_ONIL =
            "Эйприл Харриет О’Нил репортёр новостей с 6-го канала. Из-за волевого характера Эйприл и преданности любимому делу её мнение часто шло вразрез со взглядами Бёрна Томпсона, её начальника. Также она неоднократно конфликтовала с Верноном Фенвиком, оператором, чьё эго и трусость наталкивало его на обвинение Эйприл при любых обстоятельствах непреодолимой силы. Познакомившись с черепашками-ниндзя освещала их проитвостояние со Шредером. Выступала как защитница черепашек, т.к бытовало мнение о том что они вызывают угрозу для города."
        const val WONDER_WOMAN =
            "Чудо-женщина, настоящее имя которой Диана, родилась на Райском острове. Она, дочь королевы Ипполиты, стала первым ребенком, родившимся на этом острове, за три тысячи лет до появления бессмертных амазонок. Одна из представителей Диги Справедливости."
        const val SUPERMAN =
            "Супермен - супергерой, защитник города Метрополиса. По происхождению - инопланетянин. Его родная планета - Криптон. Будучи ребёнком, после взрыва родной планеты, был отпрален на Землю. Приземлившийся Кал-Эл был найден бездетной парой фермеров. Они усыновили его и вырастили, скрывая необычное происхождение мальчика. Будущий Супермен получил земное имя Кларк Кент. Как Кларк Кент, Супермен стал работать репортером в редакции газеты \"Дейли Планет\". Там он познакомился, влюбился, а впоследствии и женился на своей коллеге, журналистке Лоис Лейн. Супермен — один из основателей и официальный лидер организации супергероев — Лига Справедливости."
        const val RAVEN =
            "Ворона - дочь земной женщины Ареллы и могущественного демона Тригона . Её происхождение было долго скрыто от неё самой. Девочка была забрана в реальность под названием Азарат, где воспитывалась и обучалась богиней Азарой (Azar).  Во многом её обучение способствовало тому, чтобы Ворона умела контролировать свои эмоции, поскольку её сильные магические способности могли помочь Тригону обрести огромное влияние на Земле, а через эмоции он мог управлять дочерью.  Из-за пребывания  в другом измерении, Рейчел подолгу не видела родную мать, из-за чего они в значительной степени отдалились друг от друга. После смерти Азары, Рейчел первый раз встретилась со своим отцом, после чего впервые полностью осознала всё свое демоническое наследие.  Это, в конце концов, заставило Ворону покинуть Азарат и поселиться на Земле, где она смогла найти своё призвание. " +
                    "И хотя ей было отказано в членстве Лигой Справедливости, Ворона стала одним из самых знаменитых из Титанов.Рэйвен — эмпат, способная телепортировать своё астральное тело, которое может как участвовать в бою, так и служить «глазами и ушами» героини."
        const val DAREDEVIL =
            "В детстве, в результате несчастного случая (спасая пожилого мужчину), подвергся воздействию радиоактивного вещества. После чего Мэтт теряет зрение, но обретает способность \"радарного зрения\", и обостренные чувства д осверх человеческих возможностей. Днем работает адвокатом, а с наступлением ночи выходит на защиту города."
        const val HARLEY_QUINN =
            "Харлин Куинзел, уроженка Бруклина, Нью-Йорк, была интерном в психиатрической клинике Аркхэм. Она упросила руководство позволить ей проводить сеансы с Джокером , а когда это произошло - попала под харизму маньяка. Она влюбилась и помогала маньяку сбегать раз за разом. Однажды ее поймали, и из доктора она сама стала пациентом. Во время Ничьей Земли Харли смогла освободиться, нашла себе костюм арлекина и поколотила Пингвина, чем заслужила уважение Джокера. Парочка наслаждалась друг другом, пока Джокер не посадил ее в ракету и не направил ее в Робинсон-парк. Рухнула Харли практически на голову Ядовитому Плющу, что положило начало одним из самых странных отношений в комиксах. Плющ выходила ее и дала выпить специальный сок: тот дал Харли суперсилу и суперскорость - втайне хитрая рыжеволосая бестия надеялась, что отомстит руками Харли ненавистному ей Джокеру."
        const val GREEN_LANTERN =
            "Гарольд Джордан джордан получил волшебное кольцо от инопланетянина потерпевшего крушение на планете Земля. Кольцо силы было передано Джордану из-за его возможности противостоять страху и смотреть опасности \"в глаза\". Кольцо и его возможности стали понятны Джордану, и он унаследовал костюм Зелёного Фонаря. В качестве Зелёного Фонаря он патрулирует галактику и выполняет огромное количество миссий в космосе."
        const val PUNISHER =
            "После одной из мафиозных заварушек, теряет свою семью, после чего становится на тропу мести. Фрэнк благодаря своему боевому прошлому обладает большим опытом владения оружием и боевым единоборствам. Каратель значительно отличается от большинства положительных героев комиксов. Хотя все они действуют по традиционной системе закона и порядка, Каратель действует не по «традиционным» правилам. Тогда как супергерои стараются оставлять пойманных преступников в живых, надеясь на их дальнейшее исправление, Каратель убивает на своём пути всех преступников без колебаний."
        const val HULK =
            "Роберт Брюс Баннер был сыном физика-ядерщика Брайана Баннера и его жены Ребекки. Повзрослев, Брюс проявил недюжинные способности и интерес к ядерной физике и стал обучаться по этой специальности. В ходе одного из испытания радиактивной бомбы, Брюс попал под воздействие гамма-излучения, после чего с его организмом происходят сильные изменения в результате которых он может превращаться в человеообразное существо называющее себя Халк."
        const val FLASH =
            "Бартоломью Генри «Барт» Аллен был криминалистом, работающим на полицию, и вел нерасторопный образ жизни. Постоянно опаздывал на работу, и других ситуация был достаточно медлительным человеком. Все изменилось, когда во время грозы молния ударила в химикаты которые попали на Барри, после чего он обнаружил что способен развивать сверхзвуковую скорость и имеет ряд друих суперспособностей."
        const val WOLVERINE =
            "О детсвте и юности Джеймса Хоулетта практически ничего неизвестно. В течение двух месяцев он подвергался экспериментам организации под названием Оружие Икс, во главе с доктором Авраамом Корнелиусом. Цель эксперимента заключалась в создании собственной версии супер-солдата, которым являлся Капитан Америка. В результате эксперимента получил адамантовый скелет, повышенную способность к регенерации, животное чутье, а также адамантовые когти."
    }
}