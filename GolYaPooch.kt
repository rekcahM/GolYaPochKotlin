
import kotlin.random.Random      // برای تولید انتخاب تصادفی (راست یا چپ)
import java.util.Scanner         // برای گرفتن ورودی از کاربر

fun main() {
    val scanner = Scanner(System.`in`) // ساخت شیء برای گرفتن ورودی از کاربر
    var userScore = 0                 // متغیر برای نگهداری امتیاز کاربر
    var round = 1                     // شمارنده دورهای بازی

    println("به بازی گل یا پوچ خوش آمدید!")
    println("برای حدس زدن محل گل، 'left' (چپ) یا 'right' (راست) را وارد کنید.")
    println("برای خروج از بازی، 'exit' را وارد کنید.\n")

    while (true) {  // حلقه بی‌نهایت تا وقتی کاربر خارج شود
        println("دور $round") // نمایش شماره دور
        print("حدس شما (left/right): ")
        val userGuess = scanner.nextLine().trim().lowercase() // گرفتن ورودی کاربر

        if (userGuess == "exit") {
            // اگر کاربر بخواهد از بازی خارج شود
            println("خروج از بازی. امتیاز نهایی شما: $userScore")
            break
        }

        if (userGuess != "left" && userGuess != "right") {
            // بررسی اعتبار ورودی
            println("ورودی نامعتبر! لطفاً فقط 'left' یا 'right' وارد کنید.\n")
            continue
        }

        // انتخاب تصادفی رایانه (true یعنی left، false یعنی right)
        val correctHand = if (Random.nextBoolean()) "left" else "right"

        if (userGuess == correctHand) {
            // اگر کاربر درست حدس زده باشد
            println("آفرین! گل در دست $correctHand بود.")
            userScore++ // افزایش امتیاز کاربر
        } else {
            // اگر کاربر اشتباه حدس زده باشد
            println("اشتباه! گل در دست $correctHand بود.")
        }

        println("امتیاز فعلی شما: $userScore\n")
        round++ // افزایش شماره دور بازی
    }
}
