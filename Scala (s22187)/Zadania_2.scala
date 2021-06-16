println("\n")
println("-------------------------Zadanie 1----------------------------")
println("\n")
def jaki_dzień(x: String) = x match {
	case "Poniedziałek" => "Praca"
	case "Wtorek" => "Praca"
	case "Środa" => "Praca"
	case "Czwartek" => "Praca"
	case "Piątek" => "Praca"
	case "Sobota" => "Weekend"
	case "Niedziela" => "Weekend"
	case _ => "Nie ma takiego dnia"
}
println("Do zdefiniowanej funkcji jaki_dzień() wpisujemy kolejne parametry dla sprawdzenia:")
println("\n")
println("- Wtorek")
println(jaki_dzień("Wtorek"))
println("\n")
println("- Sobota")
println(jaki_dzień("Sobota"))
println("\n")
println("- Styczeń")
println(jaki_dzień("Styczeń"))
println("\n")

println("-------------------------Zadanie 3----------------------------")
println("\n")

class KontoBankowe(private var stan_konta: Double = 0.0) {
	def wplata(plus: Double): Unit = {
		stan_konta += plus
		println(s"Obecny stan konta: $stan_konta")
	}
	def wyplata(minus: Double): Unit = {
		if (stan_konta >= minus)
			stan_konta -= minus
		else
			throw new IllegalArgumentException("Na koncie jest za malo srodkow!")
		println(s"Obecny stan konta: $stan_konta")
	}
	def stan(): Unit = {
		println(s"Obecny stan konta: $stan_konta")
	}
}

val konto = new KontoBankowe

println(konto.stan())
//println("\n")
println(konto.wplata(5000))
//println("\n")
println(konto.wyplata(825.99))
//println("\n")

println("-------------------------Zadanie 2----------------------------")
println("\n")

class Osoba(val imie: String, val nazwisko: String) {
}

val os1 = new Osoba("Barrack", "Obama")
val os2 = new Osoba("Karol", "Wojtyła")
val os3 = new Osoba("Quentin", "Tarantino")

def powitanie(x: Osoba): Unit = x.nazwisko match {
	case "Obama" => println("Good Morning mr President")
	case "Wojtyła" => println("Szczęść Boże!")
	case "Tarantino" => println("Oh my god, it's Quentin Tarantino, hi!")
	case _ => println("Hello, who are you?")
}

println(powitanie(os1))
println("\n")
println(powitanie(os2))
println("\n")
println(powitanie(os3))
println("\n")
println(powitanie(new Osoba("Jan", "Frączyk")))
println("\n")

println("-------------------------Zadanie 4----------------------------")
println("\n")

println("-------------------------Zadanie 4----------------------------")
println("\n")

