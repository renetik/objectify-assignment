# Zadanie

Implementuj nový komponent podľa pripraveného podkladu.
Zanalyzuj, navrhni a priprav potrebné stavy, varianty komponentu, aby pokryli globálne využitie
komponentu.
Komponent má byť vizuálne a používateľsky prístupný.
Priprav jednotlivé validačné stavy komponentu
Dôraz kladieme na precízne grafické spracovanie, technickú realizáciu a jednoduchú použiteľnosť
vytvoreného komponentu ostatnými developermi mobilných aplikácií

Vytvorte všeobecné Jetpack Compose InputView
Implementujte nové Jetpack Compose View podľa pripraveného dizajnového podkladu.
Zamerajte sa na flexibilitu a rozšíriteľnosť komponentu.
Vytvorte PasswordInput pomocou InputView
Použite vytvorený komponent a implementujte nové Jetpack Compose View s názvom PasswordInput.
Komponent by mal:
Jasne komunikovať požiadavky na heslo používateľovi.
Zabezpečiť dobrý používateľský zážitok (UX).
Byť ľahko použiteľný a rozšíriteľný.
Umožniť jednoduchú zmenu štýlu.
Požiadavky na heslo
Minimálne 8 znakov
Aspoň jedno veľké písmeno
Aspoň jedno číslo
Aspoň jeden špeciálny znak (? = # / %)

Platforma: Android (mobilné zariadenia)

![Screenshot 2025-06-20 at 12.26.18.png](Screenshot%202025-06-20%20at%2012.26.18.png)

Podklady k zadaniu
Použi v zadaní nasledovné štýly aby si zachoval konzistentnosť
v komponentoch.

![Screenshot 2025-06-20 at 12.27.49.png](Screenshot%202025-06-20%20at%2012.27.49.png)
surface colors
color/surface/x-high
core/gray/500
#8C8C9A

color/surface/x-low
core/gray/00
#FFFFFF

color/surface/brand
o2/blue/500
#0050FF

color/surface/danger
core/red/600
#DC2828

color/surface/danger-variant
core/red/100
#FFDCDC

color/surface/warning
core/yellow/700
#A56315

color/surface/warning-variant
core/yellow/100
#FAF1B6

content colors
color/content/on-neutral/xx-high
core/gray/950
#2C2C31

color/content/on-neutral/medium
core/gray/500
#8C8C9A

color/content/on-neutral/low
core/gray/300
#C9C9CE

color/content/on-neutral/danger
core/red/600
#DC2828

color/content/on-neutral/warning
core/red/700
#A56315

state colors
color/state/default/hover
core/alpha/dim/50
#1A1A1A0F, 6%

color/state/default/focus
core/alpha/dim/800
#1A1A1ACC, 80%

![Screenshot 2025-06-20 at 12.27.58.png](Screenshot%202025-06-20%20at%2012.27.58.png)
Label M
font.label.m
Token
Value

Mobile
375
px
+
Family
font-font-family
Inter
Size
font-label-m-size
16
px
Weight
font-label-m-weight
500
Line-height
font-label-m-line-height
22
px
Letter spacing
font-label.m-letter-spc
0.16
px
Label S
font.label.s
Token
Value

Mobile
375
px
+
Family
font-font-family
Inter
Size
font-label-s-size
14
px
Weight
font-label-s-weight
550
Line-height
font-label-s-line-height
17
px
Letter spacing
font-label-s-letter-spc
0.16
px
Body M
font.body.m
Token
Value

Mobile
375
px
+
Family
font-font-family
Inter
Size
font-body-m-size
16
px
Weight
font-body-m-weight
400
Line-height
font-body-m-line-height
22
px
Letter spacing
font-body-m-letter-spc
0.01
px
Paragraph spacing
N/A
20
px
List spacing
N/A
6
px


![Screenshot 2025-06-20 at 12.28.08.png](Screenshot%202025-06-20%20at%2012.28.08.png)
radius
dimension/radius/input
12px
spacing
dimension/xs
8px
dimension/s
12px
dimension/m
16px
dimension/l
20px