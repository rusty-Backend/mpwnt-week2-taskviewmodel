# mpwnt-week2-taskviewmodel
mobile-programmin-with-native-technologies channel week 2 taskviewmodel

## Video
https://www.youtube.com/shorts/uGDeJuJoctA

## Kuvaus

Viikko 2 tehtävässä päädyttiin melko samanlaiseen sovellukseen kuin ensimmäisellä viikolla. Käyttäjä pystyy lisämään taskin listaan, suodatamaan task listan joko päivämäärän tai tehdyn taskin perusteella ja merkkaamaan taskin tehdyksi tai ei tehdyksi.

---

## Miten viikko 2 eroaa viikon 1 sovelluksesta?
1. Vanhan Done/Undone painikkeen tilalla on Checkbox joka on visualisesti paljon miellyttävempi.
2. forEach + Column listan sijaan käytetään LazyColumn joka huomattavasti parempi työkalu listojen luomiseen, koska se hallinnoi listoja automaattisesti.
3. TaskFunctions.kt:n logiikka on siirretty TaskViewModel-luokkaan.Viikolla 1 HomeScreen.kt hallitsi listaa remember-tilassa ja kutsui funktioita itse. Nyt TaskViewModel hallinnoi task-listaa ja sovelluslogiikkaa, ja HomeScreen vain kutsuu ViewModelin funktioita.
4. Käytössä on mutableStateOf, jonka ansiosta UI päivittyy automaattisesti aina kun data muuttuu. UI:n päivitystä ei tarvitse tehdä manuaalisesti.

---

## Rakenne

### /week2_taskviewmodel/domain/

**MockTasks.kt**  
Sisältää kaikki hard koodatut mockTaskit eli Task luokan elementtejä valmiilla arvoilla, joilla sitten alustetaan Task lista

**Task.kt**  
Sisältää Task luokan määrittelyn, id, title, description, priority, dueDate, done

**TaskFunctions.kt**  
Viime viikon tehtävästä jäänyt raunio jota ei enää käytetä. Sisältää perus funktioita task listan muokkaamiseen

---

### /week2_taskviewmodel/ui/

**HomeScreen.kt**  
Luo kaikki UI komponentit ja kutsuu funktioita TaskViewmodel.kt

---

### /week2_taskviewmodel/viewmodel/

**TaskViewModel**  
Sisältää Task listan muokkaamiseen tarvittavat funktiot kuten, addTask, toggleDone, removeTask, filterByDone, sortByDueDate, resetTasks

