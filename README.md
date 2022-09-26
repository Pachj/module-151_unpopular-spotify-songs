# Most Unpopular Spotify Songs

Benutzte Daten: https://www.kaggle.com/datasets/estienneggx/spotify-unpopular-songs?select=unpopular_songs.csv

Das DB Passwort als auch der Username sind in application.properties. Dies müsste für einen produktiven Einsatz geändert werden.


Wir haben zum Start eher ungünstige Daten ausgewählt. Die beiden Tabellen waren nicht bereits miteinander verbunden und wir mussten selbst einen Fremdschlüssel erstellen, was sich nicht so einfach gestaltete. Durch das Entfremden der Spalte Artist_name auf der Tabelle Song_Entity hatten wir das Problem, dass es dort einige Einträge gab, welche keinem Artisten auf der Artist Tabelle entsprach. Wir mussten deshalb ca. 5500 Einträge direkt im CSV korrigieren.
Nachdem wir diese Hürde gemeistert hatten, konnten wir gut weiterarbeiten. Wir hatten eine gute Aufgabenaufteilung und wo wir alleine nicht weiterkamen, haben wir uns gegenseitig Best möglichst geholfen.

## Herausforderungen

* Eine Herausforderung war der Return Value eines Queries, welches zwei Spalten zurück gibt. Wir haben dies am Ende mit einem Object Array gelöst.
* Wir hatten Probleme, dass Spring uns auf allen Endpoints leere returns zurückgegeben hat. Dies hat daran gelegen, dass wir keine getter in der Entity Klasse hatten.

## Mögliche Verbesserungen
* Der Return mit einem Object Array funktioniert, könnte aber schöner gelöst werden, insbesondere in Hinsicht Typensicherheit.
* Aktuell funktioniert der Join aufgrund der Konfiguration, dass "eager fetching" gemacht wird. Dies müsste man bei einem möglichen produktiven Einsatz noch als Property festlegen, um sicher zu gehen, dass es auch in einer anderen Umgebung funktioniert.
* Wir fangen den Error nicht ab, wenn das Limit bei "findAllWithLimit" auf 0 gesetzt wird. Diesen Fehler müsste man abfangen.
* Normalerweise würden wir für das Testing nicht die Daten aus der im Projekt verwendeten Datenbank benutzen. Für uns sind diese Tests eher sinnlos und auch sehr fehleranfällig, da sie bei Änderungen der Daten vermutlich direkt fehlschlagen. Da dies aber nicht gefordert wurde, haben wir das Testing trotzdem mit den eigentlichen Daten durchgeführt.
* Ebenfalls beim Testing ist nicht optimal, dass einige Queries nur über den Controller erreichbar sind. Somit mussten wir einen Controller instanziieren und den Endpoint aufrufen, um das Query zu testen. Das sehen wir als sehr unschön an, da wir dann im RepositoryTest nicht mehr nur die eigentliche Repository Klasse testen.



Wir sind zufrieden mit dem Resultat. Wir haben alle Anforderungen erfüllt und versucht uns möglichst informative Datenbankabfragen einfallen zu lassen.
Es gibt wie beschrieben noch einige Punkte welche verbessert werden könnten, aber weder die Funktionalität noch die Bewertungskriterien tangieren. Aus diesem Grund geben wir uns selbst die **Note 6** für dieses Projekt.
