package com.grancanaria.explorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            Greeting(navController)
        }

        composable("explore") {
            ExploreScreen(navController)
        }

        composable("nature") {
            NatureScreen(navController)
        }

        composable("tamadaba") {
            TamadabaScreen(navController)
        }
        composable("roque") {
            RoqueScreen(navController)
        }

        composable("pico") {
            PicoScreen(navController)
        }
        composable("beaches") {
            BeachesScreen(navController)
        }
        composable("culture") {
            CultureScreen(navController)
        }
        composable("food") {
            FoodScreen(navController)
        }
        composable("wildlife") {
            WildlifeScreen(navController)
        }
        composable("plants") {
            PlantsScreen(navController)
        }
        composable("cities") {
            CitiesScreen(navController)
        }
        composable("sustainability") {
            SustainabilityScreen(navController)
        }
    }
}

@Composable
fun Greeting(navController: NavHostController) {

    var currentImage by remember {
        mutableStateOf(0)
    }

    val images = listOf(
        R.drawable.gran_canaria_1,
        R.drawable.gran_canaria_2,
        R.drawable.gran_canaria_3,
        R.drawable.gran_canaria_4
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(1500)
            currentImage = (currentImage + 1) % images.size
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.gran_canaria_1),
            contentDescription = "Gran Canaria",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.12f))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(120.dp))

            Text(
                text = "Discover Gran Canaria",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Explore nature, culture, food,\nwildlife and sustainability.",
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    navController.navigate("explore")
                }
            ) {
                Text("Explore More")
            }

            Spacer(modifier = Modifier.height(100.dp))

            Image(
                painter = painterResource(id = images[currentImage]),
                contentDescription = "Slideshow",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .clip(RoundedCornerShape(24.dp))
            )

            Spacer(modifier = Modifier.height(100.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xEE001A1A),
                        RoundedCornerShape(24.dp)
                    )
                    .padding(24.dp)
            ) {

                Column {

                    Text(
                        text = "Frequently Asked Questions",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    FaqItem(
                        question = "When is the best time to visit Gran Canaria?",
                        answer = "Gran Canaria has pleasant weather throughout the year."
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    FaqItem(
                        question = "What are the most popular attractions?",
                        answer = "Maspalomas Dunes, Roque Nublo, Las Palmas and Vegueta are among the most popular attractions."
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    FaqItem(
                        question = "Is Gran Canaria suitable for families?",
                        answer = "Yes. The island offers beaches, parks, culture and many family-friendly activities."
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
@Composable
fun ExploreScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1E3C6))
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Button(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text("← Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Explore Gran Canaria",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF5D4037)
        )

        Spacer(modifier = Modifier.height(24.dp))

        CategoryCard(
            title = "Nature",
            image = R.drawable.tamadaba,
            onClick = { navController.navigate("nature") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CategoryCard(
            title = "Beaches",
            image = R.drawable.maspalomas,
            onClick = { navController.navigate("beaches") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CategoryCard(
            title = "Culture",
            image = R.drawable.vegueta,
            onClick = { navController.navigate("culture") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CategoryCard(
            title = "Food",
            image = R.drawable.papas_arrugadas,
            onClick = { navController.navigate("food") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CategoryCard(
            title = "Wildlife & Birds",
            image = R.drawable.dolphin,
            onClick = { navController.navigate("wildlife") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CategoryCard(
            title = "Plants",
            image = R.drawable.dragon_tree,
            onClick = { navController.navigate("plants") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CategoryCard(
            title = "Cities",
            image = R.drawable.las_palmas,
            onClick = { navController.navigate("cities") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CategoryCard(
            title = "Sustainability",
            image = R.drawable.barranco_tirajana,
            onClick = { navController.navigate("sustainability") }
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}
@Composable
fun CategoryCard(
    title: String,
    image: Int,
    onClick: () -> Unit = {}
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Box {

            Image(
                painter = painterResource(id = image),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.35f))
            )

            Text(
                text = title,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
@Composable
fun FaqItem(
    question: String,
    answer: String
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(
                Color.Black.copy(alpha = 0.35f),
                RoundedCornerShape(16.dp)
            )
            .clickable {
                expanded = !expanded
            }
            .padding(16.dp)
    ) {

        Text(
            text = question,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        if (expanded) {

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = answer,
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}
@Composable
fun NatureCard(
    title: String,
    image: Int,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Box {

            Image(
                painter = painterResource(id = image),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.35f))
            )

            Text(
                text = title,
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
@Composable
fun NatureScreen(navController: NavHostController) {

    var currentImage by remember {
        mutableStateOf(0)
    }

    val natureImages = listOf(
        R.drawable.tamadaba,
        R.drawable.roque,
        R.drawable.pico_nieves
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            currentImage = (currentImage + 1) % natureImages.size
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1E3C6))
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(id = natureImages[currentImage]),
            contentDescription = "Nature Slideshow",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("← Back")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Nature & Mountains of Gran Canaria",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Tamadaba Forest",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Tamadaba Natural Park is one of the largest pine forests in Gran Canaria. The area is famous for its Canary Pine trees, dramatic cliffs and spectacular views of the Atlantic Ocean. It is a popular destination for hiking and nature photography."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Roque Nublo",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Roque Nublo is one of the most iconic landmarks of Gran Canaria. This volcanic rock formation rises approximately 80 metres above its base and offers breathtaking panoramic views across the island."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Pico de las Nieves",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Pico de las Nieves is the highest point on the island at around 1,949 metres above sea level. Visitors can enjoy stunning mountain scenery and, on clear days, views of Mount Teide on Tenerife."
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
@Composable
fun TamadabaScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1E3C6))
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(R.drawable.tamadaba),
            contentDescription = "Tamadaba",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("← Back")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Tamadaba Forest",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Tamadaba Natural Park is one of the largest pine forests in Gran Canaria. It is famous for its Canary Pine trees, volcanic landscapes and breathtaking views of the Atlantic Ocean."
            )
        }
    }
}
    @Composable
    fun RoqueScreen(navController: NavHostController) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF1E3C6))
                .verticalScroll(rememberScrollState())
        ) {

            Image(
                painter = painterResource(R.drawable.roque),
                contentDescription = "Roque Nublo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Button(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Text("← Back")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Roque Nublo",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Roque Nublo is one of the most famous landmarks in Gran Canaria. This volcanic rock formation rises about 80 metres high and offers spectacular panoramic views across the island."
                )
            }
        }
    }

    @Composable
    fun PicoScreen(navController: NavHostController) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF1E3C6))
                .verticalScroll(rememberScrollState())
        ) {

            Image(
                painter = painterResource(R.drawable.pico_nieves),
                contentDescription = "Pico de las Nieves",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Button(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Text("← Back")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Pico de las Nieves",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Pico de las Nieves is the highest point in Gran Canaria at approximately 1,949 metres above sea level. Visitors enjoy stunning mountain scenery and views of nearby Tenerife on clear days."
                )
            }
        }
    }
@Composable
fun BeachesScreen(navController: NavHostController) {

    var currentImage by remember {
        mutableStateOf(0)
    }

    val beachImages = listOf(
        R.drawable.maspalomas,
        R.drawable.amadores,
        R.drawable.playa_ingles,
        R.drawable.las_canteras
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            currentImage = (currentImage + 1) % beachImages.size
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1E3C6))
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(id = beachImages[currentImage]),
            contentDescription = "Beach Slideshow",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("← Back")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Beaches of Gran Canaria",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Maspalomas Beach",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Maspalomas is famous for its golden sand dunes and long coastline. It is one of the most iconic beaches in Gran Canaria and attracts visitors from around the world."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Amadores Beach",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Amadores Beach is known for its calm turquoise waters and family-friendly atmosphere. The beach is perfect for swimming, relaxing and enjoying the sunshine."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Playa del Inglés",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Playa del Inglés is one of the liveliest beaches on the island. Visitors enjoy water sports, restaurants, shopping areas and a vibrant coastal environment."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Las Canteras Beach",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Las Canteras Beach is located in Las Palmas and is considered one of the best urban beaches in Europe. Its natural reef provides excellent swimming and snorkeling conditions."
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
@Composable
fun CultureScreen(navController: NavHostController) {

    var currentImage by remember {
        mutableStateOf(0)
    }

    val cultureImages = listOf(
        R.drawable.vegueta,
        R.drawable.casa_colon,
        R.drawable.cathedral_santa_ana,
        R.drawable.folklore
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            currentImage = (currentImage + 1) % cultureImages.size
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1E3C6))
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(id = cultureImages[currentImage]),
            contentDescription = "Culture Slideshow",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("← Back")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Culture of Gran Canaria",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Vegueta",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Vegueta is the historic district of Las Palmas. Its cobblestone streets, traditional architecture and charming plazas reflect the island's rich history."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Casa de Colón",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Casa de Colón is one of the most important museums in Gran Canaria. It explores the relationship between the Canary Islands and the Americas."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Cathedral of Santa Ana",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "The Cathedral of Santa Ana is one of the most iconic landmarks on the island. Its impressive architecture attracts visitors from around the world."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Canarian Folklore",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Traditional Canarian music, dances and festivals remain an important part of local culture and identity throughout Gran Canaria."
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
@Composable
fun FoodScreen(navController: NavHostController) {

    var currentImage by remember {
        mutableStateOf(0)
    }

    val foodImages = listOf(
        R.drawable.papas_arrugadas,
        R.drawable.mojo_rojo,
        R.drawable.mojo_verde,
        R.drawable.bienmesabe,
        R.drawable.queso_flor,
        R.drawable.sancocho
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            currentImage = (currentImage + 1) % foodImages.size
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1E3C6))
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(id = foodImages[currentImage]),
            contentDescription = "Food Slideshow",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("← Back")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Traditional Food of Gran Canaria",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Papas Arrugadas",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Papas Arrugadas are small potatoes boiled in salty water until a wrinkled skin forms. They are one of the most famous dishes in the Canary Islands."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Mojo Rojo",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Mojo Rojo is a traditional red sauce made with peppers, garlic, olive oil and spices. It is often served with potatoes and grilled dishes."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Mojo Verde",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Mojo Verde is a green sauce prepared with coriander, garlic and olive oil. It is widely used in Canarian cuisine."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Bienmesabe",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Bienmesabe is a sweet dessert made from almonds, sugar and eggs. It is one of the best-known traditional desserts in Gran Canaria."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Queso Flor",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Queso Flor is a unique local cheese produced using vegetable rennet from cardoon flowers. It is considered a specialty of the island."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Sancocho Canario",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Sancocho Canario is a traditional fish dish often served during celebrations. It combines salted fish, potatoes and sweet potatoes."
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
@Composable
fun WildlifeScreen(navController: NavHostController) {

    var currentImage by remember {
        mutableStateOf(0)
    }

    val wildlifeImages = listOf(
        R.drawable.dolphin,
        R.drawable.sea_turtle,
        R.drawable.giant_lizard,
        R.drawable.gecko,
        R.drawable.angel_shark,
        R.drawable.pilot_whale,
        R.drawable.barn_owl,
        R.drawable.kestrel,
        R.drawable.yellow_legged_gull
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            currentImage = (currentImage + 1) % wildlifeImages.size
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1E3C6))
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(id = wildlifeImages[currentImage]),
            contentDescription = "Wildlife Slideshow",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("← Back")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Wildlife & Birds of Gran Canaria",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Atlantic Dolphins",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Gran Canaria is one of the best places in Europe to observe dolphins in their natural habitat. Boat tours regularly spot several dolphin species."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Sea Turtles",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Sea turtles are an important part of the marine ecosystem around the Canary Islands. Conservation programs help protect these animals."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Gran Canaria Giant Lizard",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "The giant lizard is one of the island's most unique reptiles. It is native to the Canary Islands and can often be seen in rocky areas."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Geckos",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Small geckos are commonly found throughout Gran Canaria. They are harmless and help control insect populations."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Angel Sharks & Pilot Whales",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "The waters around Gran Canaria support a rich marine environment including angel sharks and pilot whales."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Bird Species",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Birds such as barn owls, kestrels and yellow-legged gulls can be found across the island and are important parts of the local ecosystem."
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
@Composable
fun PlantsScreen(navController: NavHostController) {

    var currentImage by remember {
        mutableStateOf(0)
    }

    val plantImages = listOf(
        R.drawable.dragon_tree,
        R.drawable.canary_pine,
        R.drawable.euphorbia,
        R.drawable.palm_tree
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            currentImage = (currentImage + 1) % plantImages.size
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1E3C6))
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(id = plantImages[currentImage]),
            contentDescription = "Plants Slideshow",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("← Back")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Plants of Gran Canaria",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Dragon Tree",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "The Dragon Tree is one of the most famous plants of the Canary Islands. It is known for its unusual shape and red sap, often called dragon's blood."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Canary Pine",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "The Canary Pine is a unique tree adapted to volcanic environments. It forms large forests in the mountains of Gran Canaria."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Euphorbia",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Euphorbia plants are well adapted to dry conditions and are common across the island's coastal and volcanic landscapes."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Canary Island Palm",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "The Canary Island Palm is one of the island's most recognizable trees and is widely planted in parks, gardens and natural areas."
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
@Composable
fun CitiesScreen(navController: NavHostController) {

    var currentImage by remember {
        mutableStateOf(0)
    }

    val cityImages = listOf(
        R.drawable.las_palmas,
        R.drawable.telde,
        R.drawable.arucas,
        R.drawable.agaete,
        R.drawable.teror,
        R.drawable.mogan,
        R.drawable.tejeda
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            currentImage = (currentImage + 1) % cityImages.size
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1E3C6))
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(id = cityImages[currentImage]),
            contentDescription = "Cities Slideshow",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("← Back")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Cities & Towns of Gran Canaria",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Las Palmas de Gran Canaria",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Las Palmas is the capital city of Gran Canaria. It is known for Las Canteras Beach, historic Vegueta and a vibrant cultural life."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Telde",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Telde is one of the oldest settlements on the island and has an important historical and cultural heritage."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Arucas",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Arucas is famous for its impressive neo-Gothic church and traditional rum production."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Agaete",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Agaete is a beautiful coastal town surrounded by mountains and known for its natural swimming pools."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Teror",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Teror is one of the most picturesque towns on the island and an important religious destination."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Mogán & Tejeda",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Mogán is known for its charming harbor and beaches, while Tejeda is famous for spectacular mountain scenery and traditional Canarian architecture."
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
@Composable
fun SustainabilityScreen(navController: NavHostController) {

    var currentImage by remember {
        mutableStateOf(0)
    }

    val sustainabilityImages = listOf(
        R.drawable.barranco_tirajana,
        R.drawable.solar_energy,
        R.drawable.wind_farm,
        R.drawable.cycling
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            currentImage = (currentImage + 1) % sustainabilityImages.size
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1E3C6))
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(id = sustainabilityImages[currentImage]),
            contentDescription = "Sustainability Slideshow",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("← Back")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Sustainability in Gran Canaria",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Solar Energy",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Gran Canaria enjoys abundant sunshine throughout the year, making solar energy an important renewable resource for the island."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Wind Farms",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Wind farms help generate clean electricity and reduce dependence on fossil fuels while supporting environmental sustainability."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Endesa and Clean Energy",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Endesa is one of Spain's leading energy companies and plays an important role in Gran Canaria's energy system. The company invests in renewable energy projects, supports wind and solar power generation, and works toward reducing carbon emissions. Through innovation and sustainable energy solutions, Endesa contributes to the island's transition to a cleaner and more environmentally friendly future."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Sustainable Transport",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Cycling routes, public transportation and environmentally friendly initiatives encourage more sustainable travel across the island."
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun MountainSection(
    image: Int,
    title: String,
    description: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Column {

            Image(
                painter = painterResource(id = image),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = description,
                    fontSize = 16.sp
                )
            }
        }
    }
}