println("\n")
println("-------------------------Zadanie 1----------------------------")
println("\n")

println("Tworzymy listę dni tygodnia")
val dni: List[String] = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela")
println(dni)
println("\n")

println("----1a (konwersja str -> lst z wartościami po przecinku)")
def conv1a(lst: List[String]): String = {
	var x: String = ""
	for (e <- lst) {x += e + ", "}
	x.slice(0, x.length - 2)
}
println(conv1a(dni))
println("\n")

println("----1b (dla wartości zaczynających się na 'P')")
def conv1b(lst: List[String]): String = {
	var x: String = ""
	for (e <- lst) {
		if (e.charAt(0) == 'P') 
			{x += e + ", "}} 
	x.slice(0, x.length - 2)
}
println(conv1b(dni))
println("\n")

println("----1c (pętla while)")
def conv1c(lst: List[String]): String = {
	var x: String = ""
	var index: Int = 0
	while (index < lst.length) {
		val element: String = lst(index)
		x += element + ", "
		index +=1
	}
	x.slice(0, x.length - 2)
}
println(conv1c(dni))
println("\n")

println("-------------------------Zadanie 2----------------------------")
println("\n")

println("----2a (funkcja rekurencyjna)")
def conv2a(lst: List[String]): String = {
	var result: String = {
		if (lst.isEmpty) ""
		else lst.head
	}
	if (lst.tail.isEmpty) result
	else result += ", " + conv2a(lst.tail)
	result
}
println(conv2a(dni))
println("\n")

println("----2b (funkcja rekurencyjna wypisując elementy od tyłu)")
def conv2b(lst: List[String]): String = {
	var result: String = ""
	if (lst.length == 7)
		{val lst2: List[String] = lst.reverse
		result += lst2.head + conv2b(lst2.tail)}
	else 
		if (lst.tail.isEmpty) result += ", " + lst.head
		else result += ", " + lst.head + conv2b(lst.tail)
	result
}
println(conv2b(dni))
println("\n")

println("-------------------------Zadanie 3----------------------------")
println("\n")

println("---- (rekurencja ogonowa)")

def conv3(lst: List[String]): String = {
	@annotation.tailrec
	def iter(lst2: List[String], result: String): String = {
		if (lst2.tail.isEmpty) result + lst2.head 
		else iter(lst2.tail, result + lst2.head + ", ")
	}
	iter(lst, "")
}

println(conv3(dni))
println("\n")

println("-------------------------Zadanie 4----------------------------")
println("\n")

println("----4a (wykorzystanie foldLeft)")
def conv4a(lst: List[String]): String = {
	val x: String = lst.foldLeft(""){(a: String, b: String) => a + ", " + b}
	x.slice(2, x.length)
}
println(conv4a(dni))
println("\n")

println("----4b (wykorzystanie foldRight)")
def conv4b(lst: List[String]): String = {
	val x: String = lst.foldRight(""){(a: String, b: String) => a + ", " + b}
	x.slice(0, x.length - 2)
}
println(conv4b(dni))
println("\n")

println("----4c Konwersja lista-string z metodą foldLeft dla elementów zaczynających się na 'P'")
def conv4c(lst: List[String]): String = {
	val lst2: List[String] = lst filter (_.charAt(0) == 'P')
	val x: String = lst2.foldLeft(""){(a: String, b: String) => (a + ", " + b)}
	x.slice(2, x.length)
}
println(conv4c(dni))
println("\n")

println("-------------------------Zadanie 5----------------------------")
println("\n")

println("mapa z nazwami produktów i cenami")
val prod_price = Map("Chleb" -> 4, "CocaCola" -> 7, "Whiskey" -> 80, "Ser" -> 8, "Awokado" -> 6, "Szampon" -> 12)
println(prod_price)

println("\n")
println("mapa z produktami i ich cenami po 10% obniżce wartości produktu")
val discount = prod_price map {case (key, value) => (key, value * 0.9)}
println(discount)
println("\n")

println("-------------------------Zadanie 6----------------------------")
println("\n")

println("Krotka 3-elementowa z elementami różnych typów")
val tp3 = Tuple3(1, 25.55, 'c')
println(tp3)

def print_tuple3(t: Tuple3[Any, Any, Any]) = {
	println(t._1)
	println(t._2)
	println(t._3)
}
println("\n")

println("Funkcja zwraca print każdego elementu krotki")
print_tuple3(tp3)
println("\n")

println("-------------------------Zadanie 7----------------------------")
println("\n")

println("Tworzymy mapę zwierząt i wydawanych przez nie odgłosów")
val animals = Map("Cat" -> "Meow", "Dog" -> "Woof", "Cow" -> "Muuu")
println(animals)
println("\n")

println("Wywołujemy wartość dla klucza istniejącego w mapie (Cat) -> otrzymujemy obiekt <Some> - wartość dla klucza istnieje i jest zwrócona")
println(animals.get("Cat"))
println("\n")

println("Wywołujemy wartość dla klucza nieistniejącego w mapie (Chicken) -> otrzymujemy obiekt <None> - brak wartości dla podanego klucza")
println(animals.get("Chicken"))
println("\n")

println("-------------------------Zadanie 8----------------------------")
println("\n")

println("Początkowa lista")
val zeros: List[Int] = List(0,1,0,2,0,3,0,4,0,0,5,20,55,0,106)
println(zeros)
println("\n")

def remove0(lst: List[Int]): List[Int] = {
	@annotation.tailrec
	val lst_rvrsd: List[Int] = lst.reverse
	def iter(lst2: List[Int], result: List[Int]): List[Int] = {
		if (lst2.isEmpty) result
		else
			if (lst2.head == 0) {iter(lst2.tail, result)}
			else iter(lst2.tail, lst2.head :: result)
	}
	iter(lst_rvrsd, List())
}

println("Lista bez zer")
println(remove0(zeros))
println("\n")

println("-------------------------Zadanie 9----------------------------")
println("\n")

println("Tworzymy przykładową listę integerów")
val basic: List[Int] = List(1,2,3,4,5,6,7,8,9,10)
println(basic)
println("\n")

def add1(lst: List[Int]): List[Int] = {
	lst map (n => n +1)
}
println("Przepuszczamy wcześniej utworzoną listę przez funkcję add1 zwiększającą każdy element o 1")
println(add1(basic))
println("\n")

