package com.example.data.repository

import com.example.data.model.CategoryGroup
import com.example.data.model.CategoryIconType
import com.example.data.model.CheatCategory
import com.example.data.model.CheatItem
import com.example.data.model.CheatSection

/**
 * 30+ praxisnahe Shortcuts & Befehle für Windows, Excel, Word, PowerPoint und Browser.
 */
val officeCategories: List<CheatCategory> = listOf(
    // -------------------------------------------------------------------------
    // 1. Windows (32 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "windows",
        title = "Windows",
        subtitle = "Kürzel & Befehle",
        group = CategoryGroup.OFFICE_OS,
        iconType = CategoryIconType.WINDOWS,
        sections = listOf(
            CheatSection(
                id = "win_nav",
                title = "Navigation & Fenster-Management",
                items = listOf(
                    CheatItem("win_v", "Zwischenablage-Verlauf", "Win + V", "Öffnet den Verlauf kopierter Texte und Bilder", false, listOf("clipboard", "verlauf")),
                    CheatItem("win_shift_s", "Erweitertes Bildschirmfoto", "Win + Shift + S", "Snipping Tool für Bereichs-, Fenster- oder Freiform-Screenshots", false, listOf("screenshot", "snipping")),
                    CheatItem("win_x", "Power-User Menü", "Win + X", "Schnellzugriff auf Terminal, Datenträgerverwaltung & Einstellungen", false, listOf("power", "admin")),
                    CheatItem("win_d", "Desktop anzeigen / minimieren", "Win + D", "Minimiert sofort alle Fenster oder stellt sie wieder her", false, listOf("desktop", "minimize")),
                    CheatItem("win_l", "PC sofort sperren", "Win + L", "Sperrt Windows und schützt vor unbefugtem Zugriff", false, listOf("lock", "sicherheit")),
                    CheatItem("win_e", "Datei-Explorer öffnen", "Win + E", "Öffnet ein neues Datei-Explorer-Fenster", false, listOf("explorer", "files")),
                    CheatItem("win_tab", "Task-Ansicht & Desktops", "Win + Tab", "Zeigt Zeitachse, alle Fenster und virtuelle Desktops", false, listOf("desktops", "task")),
                    CheatItem("win_ctrl_d", "Neuer virtueller Desktop", "Win + Strg + D", "Erstellt sofort einen neuen virtuellen Arbeitsbereich", false, listOf("virtual", "desktop")),
                    CheatItem("win_ctrl_f4", "Virtuellen Desktop schließen", "Win + Strg + F4", "Schließt den aktiven virtuellen Desktop", false, listOf("desktop", "close")),
                    CheatItem("win_ctrl_arrow", "Zwischen Desktops wechseln", "Win + Strg + Pfeil Links/Rechts", "Wechselt zwischen virtuellen Arbeitsbereichen", false, listOf("desktop", "switch")),
                    CheatItem("win_arrow_left", "Fenster links andocken", "Win + Pfeil Links", "Platziert das Fenster auf der linken Bildschirmhälfte", false, listOf("snap", "tile")),
                    CheatItem("win_arrow_right", "Fenster rechts andocken", "Win + Pfeil Rechts", "Platziert das Fenster auf der rechten Bildschirmhälfte", false, listOf("snap", "tile")),
                    CheatItem("win_arrow_up", "Fenster maximieren", "Win + Pfeil Oben", "Maximiert das aktive Fenster", false, listOf("maximize", "window")),
                    CheatItem("win_arrow_down", "Fenster minimieren / verkleinern", "Win + Pfeil Unten", "Verkleinert das Fenster oder minimiert es in die Taskleiste", false, listOf("minimize", "window")),
                    CheatItem("win_r", "Ausführen-Dialog", "Win + R", "Startet Programme oder Systembefehle direkt", false, listOf("run", "ausfuehren")),
                    CheatItem("win_i", "Einstellungen öffnen", "Win + I", "Öffnet die Windows-Einstellungen", false, listOf("settings", "config"))
                )
            ),
            CheatSection(
                id = "win_tools",
                title = "Shortcuts & System-Tools",
                items = listOf(
                    CheatItem("win_ctrl_shift_esc", "Task-Manager direkt öffnen", "Strg + Umschalt + Esc", "Öffnet den Task-Manager ohne Zwischenmenü", false, listOf("taskmanager", "kill")),
                    CheatItem("win_alt_prt", "Nur aktives Fenster abfotografieren", "Alt + Druck", "Kopiert Screenshot des aktiven Fensters in die Zwischenablage", false, listOf("screenshot", "window")),
                    CheatItem("win_period", "Emoji & Symbol-Auswahl", "Win + . (oder Win + ;)", "Öffnet das Panel für Emojis, Kaomojis und Sonderzeichen", false, listOf("emoji", "symbol")),
                    CheatItem("win_h", "Spracheingabe / Diktat", "Win + H", "Startet die Windows-Spracherkennung", false, listOf("dictate", "speech")),
                    CheatItem("win_pause", "Systeminformationen", "Win + Pause", "Zeigt Prozessor, RAM und Windows-Spezifikationen an", false, listOf("system", "info")),
                    CheatItem("win_k", "Drahtlos projizieren (Cast)", "Win + K", "Verbindet mit drahtlosen Displays und Bluetooth-Audio", false, listOf("cast", "display")),
                    CheatItem("win_number", "Taskleisten-App starten", "Win + [1–9]", "Startet oder fokussiert das n-te Programm in der Taskleiste", false, listOf("taskbar", "quicklaunch"))
                )
            ),
            CheatSection(
                id = "win_cli",
                title = "Wichtige Terminal & CMD Befehle",
                items = listOf(
                    CheatItem("win_sfc", "Systemdateien reparieren", "sfc /scannow", "Überprüft und repariert beschädigte Windows-Dateien", true, listOf("repair", "system")),
                    CheatItem("win_dism", "Windows Image reparieren", "DISM /Online /Cleanup-Image /RestoreHealth", "Repariert den Windows-Komponentenspeicher online", true, listOf("dism", "repair")),
                    CheatItem("win_ipconfig", "Netzwerkkonfiguration anzeigen", "ipconfig /all", "Detailansicht von IP-Adressen, DNS und MAC-Adressen", true, listOf("network", "ip")),
                    CheatItem("win_flushdns", "DNS-Cache leeren", "ipconfig /flushdns", "Löscht den lokalen Windows DNS-Auflösungs-Cache", true, listOf("dns", "network")),
                    CheatItem("win_winget_search", "Software suchen mit Winget", "winget search <name>", "Durchsucht das Windows Package Manager Repository", true, listOf("winget", "search")),
                    CheatItem("win_winget_install", "Software installieren mit Winget", "winget install <paket_id>", "Installiert Software automatisiert und unüberwacht", true, listOf("winget", "install")),
                    CheatItem("win_winget_upgrade", "Alle Programme aktualisieren", "winget upgrade --all", "Aktualisiert alle installierten Winget-Pakete auf einmal", true, listOf("winget", "update")),
                    CheatItem("win_netstat", "Aktive Verbindungen prüfen", "netstat -ano", "Listet alle offenen Verbindungen samt zugehöriger PID", true, listOf("netstat", "ports")),
                    CheatItem("win_shutdown", "Sofortiger PC-Neustart", "shutdown /r /t 0", "Startet Windows ohne Verzögerung neu", true, listOf("shutdown", "restart"))
                )
            )
        )
    ),

    // -------------------------------------------------------------------------
    // 2. Excel (32 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "excel",
        title = "Excel",
        subtitle = "Shortcuts & Formeln",
        group = CategoryGroup.OFFICE_OS,
        iconType = CategoryIconType.EXCEL,
        sections = listOf(
            CheatSection(
                id = "excel_keys",
                title = "Tastenkombinationen & Navigation",
                items = listOf(
                    CheatItem("ex_f4", "Zellbezug sperren / Wiederholen", "F4", "Schaltet zwischen absolutem (\$A\$1) und relativem Bezug um", false, listOf("bezug", "absolut")),
                    CheatItem("ex_filter", "AutoFilter umschalten", "Strg + Umschalt + L", "Aktiviert oder deaktiviert Filter in der aktuellen Tabelle", false, listOf("filter", "tabelle")),
                    CheatItem("ex_flash", "Blitzvorschau (Flash Fill)", "Strg + E", "Erkennt Muster und füllt Spalten automatisch logisch aus", false, listOf("muster", "auto")),
                    CheatItem("ex_now", "Aktuelles Datum einfügen", "Strg + .", "Fügt das heutige Datum als Festwert in die Zelle ein", false, listOf("datum", "time")),
                    CheatItem("ex_time", "Aktuelle Uhrzeit einfügen", "Strg + Umschalt + .", "Fügt die aktuelle Uhrzeit als statischen Wert ein", false, listOf("zeit", "uhrzeit")),
                    CheatItem("ex_table", "Als Tabelle formatieren", "Strg + T", "Wandelt ausgewählten Datenbereich in eine dynamische Tabelle um", false, listOf("tabelle", "format")),
                    CheatItem("ex_autosum", "AutoSumme berechnen", "Alt + Shift + =", "Fügt automatisch die SUMME-Formel für den Block ein", false, listOf("summe", "autosum")),
                    CheatItem("ex_select_col", "Ganze Spalte markieren", "Strg + Leertaste", "Markiert die gesamte aktive Tabellenspalte", false, listOf("spalte", "markieren")),
                    CheatItem("ex_select_row", "Ganze Zeile markieren", "Shift + Leertaste", "Markiert die gesamte aktive Tabellenzeile", false, listOf("zeile", "markieren")),
                    CheatItem("ex_insert_cells", "Zellen/Zeilen einfügen", "Strg + Plus (+)", "Öffnet Dialog zum Einfügen neuer Zellen, Zeilen oder Spalten", false, listOf("insert", "einfuegen")),
                    CheatItem("ex_delete_cells", "Zellen/Zeilen löschen", "Strg + Minus (-)", "Löscht markierte Zeilen, Spalten oder Zellen", false, listOf("delete", "loeschen")),
                    CheatItem("ex_hide_row", "Zeile ausblenden", "Strg + 9", "Blendet die aktuell ausgewählte Zeile aus", false, listOf("hide", "zeile")),
                    CheatItem("ex_hide_col", "Spalte ausblenden", "Strg + 0", "Blendet die aktuell ausgewählte Spalte aus", false, listOf("hide", "spalte")),
                    CheatItem("ex_edit_cell", "Zelle bearbeiten", "F2", "Aktiviert den Bearbeitungsmodus der markierten Zelle", false, listOf("edit", "zelle")),
                    CheatItem("ex_newline", "Zeilenumbruch in Zelle", "Alt + Enter", "Erzeugt einen weichen Zeilenumbruch innerhalb einer Zelle", false, listOf("newline", "umbruch")),
                    CheatItem("ex_format_dialog", "Zellen formatieren Dialog", "Strg + 1", "Öffnet den vollen Dialog für Zahlen, Ausrichtung & Rahmen", false, listOf("format", "dialog"))
                )
            ),
            CheatSection(
                id = "excel_calc",
                title = "Wichtige Formeln & Funktionen",
                items = listOf(
                    CheatItem("ex_xlookup", "Modernes Nachschlagen (XVERWEIS)", "=XVERWEIS(Suchkriterium; Suchmatrix; Rückgabematrix; [nicht_gef])", "Ersetzt SVERWEIS und WVERWEIS flexibel ohne Spaltenindex", true, listOf("sverweis", "xlookup")),
                    CheatItem("ex_sumifs", "Summe mit mehreren Bedingungen", "=SUMMEWENN(Bereich; Kriterium; [Summe_Bereich])", "Summiert Werte basierend auf Bedingungen", true, listOf("summe", "sumifs")),
                    CheatItem("ex_countifs", "Zählen wenn Bedingung zutrifft", "=ZÄHLENWENNS(Bereich1; Kriterium1; Bereich2; Kriterium2)", "Zählt Zeilen, die mehrere Kriterien erfüllen", true, listOf("count", "zaehlen")),
                    CheatItem("ex_unique", "Eindeutige Werte filtern", "=EINDEUTIG(Array; [nach_Spalte]; [genau_einmal])", "Gibt eine Liste aller duplikatfreien Einträge zurück", true, listOf("unique", "duplikate")),
                    CheatItem("ex_filter_func", "Dynamischer Zeilenfilter", "=FILTER(Array; Einschließen; [wenn_leer])", "Filtert Daten dynamisch in ein überlaufendes Array", true, listOf("filter", "matrix")),
                    CheatItem("ex_sort", "Dynamische Sortierung", "=SORTIEREN(Array; [Sortierindex]; [Reihenfolge])", "Sortiert Datenbereich aufsteigend oder absteigend", true, listOf("sort", "matrix")),
                    CheatItem("ex_index_match", "Index & Vergleich Kombination", "=INDEX(Rückgabespalte; VERGLEICH(Suchwert; Suchspalte; 0))", "Klassische, stabile Matrixabfrage für ältere Excel-Versionen", true, listOf("index", "match")),
                    CheatItem("ex_if_error", "Fehler abfangen (WENNFEHLER)", "=WENNFEHLER(Formel; Wert_wenn_Fehler)", "Gibt sauberen Fallback aus (#NV oder #DIV/0! vermeiden)", true, listOf("fehler", "error")),
                    CheatItem("ex_textjoin", "Texte mit Trennzeichen verbinden", "=TEXTKETTE(\", \"; WAHR; A1:A10)", "Verbindet Zellinhalte und ignoriert leere Zellen", true, listOf("text", "join")),
                    CheatItem("ex_concat", "Verketten von Zellen", "=A1 & \" \" & B1", "Einfache Zeichenketten-Kombination mit Kaufmanns-Und", true, listOf("concat", "string")),
                    CheatItem("ex_today", "Dynamisches Tagesdatum", "=HEUTE()", "Liefert bei jeder Neuberechnung das aktuelle Datum", true, listOf("heute", "datum")),
                    CheatItem("ex_networkdays", "Arbeitstage berechnen", "=NETTOARBEITSTAGE(Start; Ende; [Feiertage])", "Berechnet Werktage ohne Wochenenden und Feiertage", true, listOf("arbeitstage", "tage")),
                    CheatItem("ex_left_mid_right", "Teiltext extrahieren (TEIL)", "=TEIL(Text; Erstes_Zeichen; Anzahl_Zeichen)", "Schneidet definierte Zeichenfolgen aus Texten aus", true, listOf("teil", "text")),
                    CheatItem("ex_trim", "Überflüssige Leerzeichen löschen", "=GLÄTTEN(Text)", "Entfernt doppelte oder führende/abschließende Leerzeichen", true, listOf("glaetten", "trim")),
                    CheatItem("ex_round", "Kaufmännisch runden", "=RUNDEN(Zahl; 2)", "Rundet eine Zahl auf die angegebene Dezimalstellenanzahl", true, listOf("runden", "math")),
                    CheatItem("ex_len", "Textlänge ermitteln", "=LÄNGE(Text)", "Gibt die exakte Anzahl an Zeichen inklusive Leerzeichen zurück", true, listOf("laenge", "len"))
                )
            )
        )
    ),

    // -------------------------------------------------------------------------
    // 3. Word (31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "word",
        title = "Word",
        subtitle = "Formatierung",
        group = CategoryGroup.OFFICE_OS,
        iconType = CategoryIconType.WORD,
        sections = listOf(
            CheatSection(
                id = "word_edit",
                title = "Text- & Formatierungs-Shortcuts",
                items = listOf(
                    CheatItem("w_format_copy", "Formatierung übertragen", "Strg + Shift + C / V", "Kopiert nur das Styling eines Texts und wendet es an", false, listOf("style", "format")),
                    CheatItem("w_clear_format", "Formatierung zurücksetzen", "Strg + Leertaste", "Entfernt manuelle Zeichenformatierungen sofort", false, listOf("reset", "reinigen")),
                    CheatItem("w_page_break", "Harter Seitenumbruch", "Strg + Enter", "Fügt sofort einen sauberen neuen Seitenumbruch ein", false, listOf("seite", "break")),
                    CheatItem("w_caps", "Groß-/Kleinschreibung ändern", "Shift + F3", "Wechselt zwischen GROSS, klein und Erster Buchstabe Groß", false, listOf("caps", "case")),
                    CheatItem("w_replace", "Suchen und Ersetzen Dialog", "Strg + H", "Öffnet den Dialog für Text- und Format-Ersetzungen", false, listOf("find", "replace")),
                    CheatItem("w_find", "Navigationsbereich Suche", "Strg + F", "Öffnet die Seitenleiste zur Schnellsuche im Dokument", false, listOf("suche", "find")),
                    CheatItem("w_center", "Absatz zentrieren", "Strg + E", "Richtet den markierten Absatz horizontal mittig aus", false, listOf("center", "align")),
                    CheatItem("w_left", "Absatz linksbündig", "Strg + L", "Richtet den Text an der linken Kante aus", false, listOf("left", "align")),
                    CheatItem("w_right", "Absatz rechtsbündig", "Strg + R", "Richtet den Text an der rechten Kante aus", false, listOf("right", "align")),
                    CheatItem("w_justify", "Blocksatz anwenden", "Strg + B", "Formatiert Text als bündigen Blocksatz", false, listOf("justify", "blocksatz")),
                    CheatItem("w_super", "Hochgestellt formatieren", "Strg + Shift + +", "Schaltet ausgewählte Zeichen in den Exponenten-Modus", false, listOf("super", "hochgestellt")),
                    CheatItem("w_sub", "Tiefgestellt formatieren", "Strg + +", "Schaltet ausgewählte Zeichen in den Index-Modus", false, listOf("sub", "tiefgestellt")),
                    CheatItem("w_font_grow", "Schriftgröße stufenweise erhöhen", "Strg + Shift + >", "Vergrößert Schriftgröße um den nächsten Standardwert", false, listOf("grow", "font")),
                    CheatItem("w_font_shrink", "Schriftgröße stufenweise verringern", "Strg + Shift + <", "Verkleinert Schriftgröße um den nächsten Standardwert", false, listOf("shrink", "font")),
                    CheatItem("w_footnote", "Fußnote einfügen", "Alt + Strg + F", "Platziert eine Fußnote an der Cursor-Position", false, listOf("footnote", "quelle")),
                    CheatItem("w_endnote", "Endnote einfügen", "Alt + Strg + D", "Platziert eine Endnote am Dokumentenende", false, listOf("endnote", "quelle"))
                )
            ),
            CheatSection(
                id = "word_nav",
                title = "Navigation & Dokumenten-Tools",
                items = listOf(
                    CheatItem("w_stats", "Wortanzahl & Zeichenstatistik", "Strg + Shift + G", "Zeigt Detailfenster mit Wörtern, Zeichen und Absätzen", false, listOf("stats", "woerter")),
                    CheatItem("w_spelling", "Rechtschreibprüfung starten", "F7", "Startet Rechtschreib- und Grammatikprüfung", false, listOf("spelling", "pruefung")),
                    CheatItem("w_thesaurus", "Thesaurus / Synonyme", "Shift + F7", "Schlägt Synonyme für das markierte Wort vor", false, listOf("thesaurus", "synonym")),
                    CheatItem("w_comment", "Kommentar einfügen", "Alt + Strg + M", "Fügt an der aktuellen Textstelle einen Review-Kommentar ein", false, listOf("comment", "review")),
                    CheatItem("w_heading_1", "Formatvorlage Überschrift 1", "Alt + Strg + 1", "Weist dem Absatz Überschrift 1 zu", false, listOf("heading", "h1")),
                    CheatItem("w_heading_2", "Formatvorlage Überschrift 2", "Alt + Strg + 2", "Weist dem Absatz Überschrift 2 zu", false, listOf("heading", "h2")),
                    CheatItem("w_heading_3", "Formatvorlage Überschrift 3", "Alt + Strg + 3", "Weist dem Absatz Überschrift 3 zu", false, listOf("heading", "h3")),
                    CheatItem("w_normal_style", "Formatvorlage Standard", "Strg + Shift + N", "Setzt den Absatz auf die normale Standard-Vorlage zurück", false, listOf("normal", "style")),
                    CheatItem("w_non_breaking_space", "Geschütztes Leerzeichen", "Strg + Shift + Leertaste", "Verhindert ungewollten Zeilenumbruch zwischen Wörtern", false, listOf("space", "umbruch")),
                    CheatItem("w_non_breaking_hyphen", "Geschützter Bindestrich", "Strg + Shift + -", "Verhindert Trennung bei Bindestrich-Wörtern", false, listOf("hyphen", "trennstrich")),
                    CheatItem("w_column_break", "Spaltenumbruch", "Strg + Shift + Enter", "Bricht in mehrspaltigen Layouts in die nächste Spalte um", false, listOf("column", "break")),
                    CheatItem("w_repeat", "Letzte Aktion wiederholen", "F4 (oder Strg + Y)", "Führt letzte Formatierung oder Aktion erneut aus", false, listOf("repeat", "redo")),
                    CheatItem("w_go_to", "Gehe zu Seite/Abschnitt", "F5 (oder Strg + G)", "Springt zu Seite, Fußnote, Tabelle oder Zeile", false, listOf("goto", "nav")),
                    CheatItem("w_show_formatting", "Formatierungszeichen einblenden", "Strg + Shift + *", "Zeigt Leerzeichen, Absätze und Tabulatoren sichtbar an", false, listOf("pilcrow", "hidden")),
                    CheatItem("w_save_as", "Speichern unter", "F12", "Öffnet sofort den Dialog zum Speichern unter neuem Namen", false, listOf("save", "dialog"))
                )
            )
        )
    ),

    // -------------------------------------------------------------------------
    // 4. PowerPoint (31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "powerpoint",
        title = "PowerPoint",
        subtitle = "Präsentation",
        group = CategoryGroup.OFFICE_OS,
        iconType = CategoryIconType.POWERPOINT,
        sections = listOf(
            CheatSection(
                id = "ppt_live",
                title = "Vortrags- & Präsentationssteuerung",
                items = listOf(
                    CheatItem("ppt_f5", "Präsentation von Beginn starten", "F5", "Startet die Präsentation ab der allerersten Folie", false, listOf("start", "first")),
                    CheatItem("ppt_shift_f5", "Präsentation ab aktueller Folie", "Shift + F5", "Startet genau an der aktuell ausgewählten Folie", false, listOf("current", "start")),
                    CheatItem("ppt_presenter_view", "Referentenansicht erzwingen", "Alt + F5", "Startet Präsentation mit Notizen und Folienvorschau", false, listOf("presenter", "notes")),
                    CheatItem("ppt_black", "Bildschirm abdunkeln (Schwarz)", "B (oder Taste .)", "Schaltet Bildschirm komplett schwarz für Fokus auf den Redner", false, listOf("black", "focus")),
                    CheatItem("ppt_white", "Bildschirm aufhellen (Weiß)", "W (oder Taste ,)", "Schaltet Bildschirm weiß für Projektionspausen", false, listOf("white", "pause")),
                    CheatItem("ppt_laser", "Laserpointer aktivieren", "Strg + L", "Verwandelt den Mauszeiger in einen roten Laserpointer", false, listOf("laser", "pointer")),
                    CheatItem("ppt_pen", "Zeichenstift aktivieren", "Strg + P", "Ermöglicht freies Zeichnen und Anmerkungen auf Folien", false, listOf("pen", "draw")),
                    CheatItem("ppt_highlighter", "Textmarker aktivieren", "Strg + I", "Hebt Folieninhalte gelb transparent hervor", false, listOf("highlighter", "marker")),
                    CheatItem("ppt_arrow_cursor", "Normaler Mauszeiger wiederherstellen", "Strg + A", "Schaltet Stift/Laser zurück auf normalen Pfeil-Cursor", false, listOf("cursor", "arrow")),
                    CheatItem("ppt_clear", "Freihandzeichnungen löschen", "E", "Löscht alle während des Vortrags gezeichneten Linien", false, listOf("erase", "loeschen")),
                    CheatItem("ppt_hide_cursor", "Mauszeiger sofort verbergen", "Strg + H", "Blendet den Mauszeiger während der Präsentation aus", false, listOf("hide", "cursor")),
                    CheatItem("ppt_jump", "Zu Folie N springen", "<Nummer> + Enter", "Springt während der Präsentation direkt zur Foliennummer", false, listOf("jump", "slide")),
                    CheatItem("ppt_all_slides", "Alle Folien im Raster anzeigen", "G (oder Strg + S)", "Öffnet Folienübersicht zum Direkt-Anwählen", false, listOf("grid", "overview")),
                    CheatItem("ppt_subtitle", "Live-Untertitel aktivieren", "J", "Schaltet automatische Live-Untertitelung ein/aus", false, listOf("subtitle", "caption")),
                    CheatItem("ppt_end", "Präsentation beenden", "Esc", "Verlässt den Vollbildmodus und kehrt zum Editor zurück", false, listOf("exit", "esc"))
                )
            ),
            CheatSection(
                id = "ppt_editing",
                title = "Folien- & Objekt-Bearbeitung",
                items = listOf(
                    CheatItem("ppt_new_slide", "Neue Folie einfügen", "Strg + M", "Erstellt eine neue leere Folie im aktuellen Layout", false, listOf("new", "slide")),
                    CheatItem("ppt_dup_slide", "Folie oder Objekt duplizieren", "Strg + D", "Erstellt ein 1:1 Duplikat der markierten Folie oder Form", false, listOf("duplicate", "copy")),
                    CheatItem("ppt_group", "Formen gruppieren", "Strg + G", "Verbindet mehrere Elemente zu einer festen Gruppe", false, listOf("group", "combine")),
                    CheatItem("ppt_ungroup", "Gruppierung aufheben", "Strg + Shift + G", "Löst eine Elementgruppe wieder in Einzelelemente auf", false, listOf("ungroup", "loesen")),
                    CheatItem("ppt_regroup", "Letzte Gruppe wiederherstellen", "Strg + Shift + J", "Fasst zuvor aufgelöste Gruppe wieder zusammen", false, listOf("regroup", "wiederholen")),
                    CheatItem("ppt_bring_front", "Ganz nach vorne bringen", "Strg + Shift + ]", "Verschiebt Objekt auf die oberste Z-Ebene", false, listOf("layer", "front")),
                    CheatItem("ppt_send_back", "Ganz nach hinten verschieben", "Strg + Shift + [", "Verschiebt Objekt auf die unterste Z-Ebene", false, listOf("layer", "back")),
                    CheatItem("ppt_constrain", "Proportionales Skalieren", "Shift + Ziehen", "Hält Seitenverhältnis von Kreisen und Quadraten perfekt", false, listOf("proportional", "shift")),
                    CheatItem("ppt_center_scale", "Aus der Mitte heraus skalieren", "Strg + Ziehen", "Vergrößert Formen symmetrisch vom Mittelpunkt aus", false, listOf("center", "scale")),
                    CheatItem("ppt_clone_drag", "Element beim Ziehen kopieren", "Strg + Ziehen", "Erzeugt beim Bewegen eines Objekts eine Kopie", false, listOf("clone", "drag")),
                    CheatItem("ppt_axis_lock", "Bewegung auf Achse sperren", "Shift + Ziehen", "Sperrt Bewegung exakt auf 0°, 45° oder 90° Winkel", false, listOf("axis", "straight")),
                    CheatItem("ppt_copy_format", "Formateigenschaften kopieren", "Strg + Shift + C", "Kopiert Farben, Schatten & Rahmen eines Objekts", false, listOf("style", "copy")),
                    CheatItem("ppt_paste_format", "Formateigenschaften anwenden", "Strg + Shift + V", "Wendet kopierte Formate auf ein anderes Objekt an", false, listOf("style", "paste")),
                    CheatItem("ppt_zoom", "Foliensortierung Zoom", "Strg + Mausrad", "Vergrößert oder verkleinert die Folienansicht", false, listOf("zoom", "view")),
                    CheatItem("ppt_notes", "Notizenbereich fokussieren", "F6", "Wechselt zwischen Folie, Gliederung und Vortragsnotizen", false, listOf("notes", "fokus")),
                    CheatItem("ppt_guide", "Hilfslinien einblenden", "Alt + F9", "Schaltet Layout- und Zentrierhilfslinien an/aus", false, listOf("guides", "raster"))
                )
            )
        )
    ),

    // -------------------------------------------------------------------------
    // 5. Browser (Chrome & Firefox - 31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "browser",
        title = "Browser",
        subtitle = "Chrome & Firefox",
        group = CategoryGroup.OFFICE_OS,
        iconType = CategoryIconType.BROWSER,
        sections = listOf(
            CheatSection(
                id = "browser_tabs",
                title = "Tab- & Fenster-Steuerung",
                items = listOf(
                    CheatItem("br_restore", "Geschlossenen Tab wiederherstellen", "Strg + Shift + T", "Öffnet den zuletzt geschlossenen Tab erneut (auch mehrfach)", false, listOf("tab", "restore")),
                    CheatItem("br_new_tab", "Neuen Tab öffnen", "Strg + T", "Öffnet einen leeren neuen Tab und fokussiert die URL", false, listOf("new", "tab")),
                    CheatItem("br_close_tab", "Aktuellen Tab schließen", "Strg + W (oder Strg + F4)", "Schließt den aktiven Tab sofort", false, listOf("close", "tab")),
                    CheatItem("br_new_window", "Neues Fenster öffnen", "Strg + N", "Startet ein separates neues Browserfenster", false, listOf("window", "new")),
                    CheatItem("br_incognito", "Privates / Inkognito-Fenster", "Strg + Shift + N / P", "Inkognito-Modus (Chrome: Strg+Shift+N, Firefox: Strg+Shift+P)", false, listOf("privat", "incognito")),
                    CheatItem("br_next_tab", "Zum nächsten Tab wechseln", "Strg + Tab (oder Strg + BildAb)", "Wechselt zum nächsten Tab nach rechts", false, listOf("next", "tab")),
                    CheatItem("br_prev_tab", "Zum vorherigen Tab wechseln", "Strg + Shift + Tab", "Wechselt zum vorherigen Tab nach links", false, listOf("prev", "tab")),
                    CheatItem("br_jump_tab", "Direkt zu Tab 1–8 springen", "Strg + [1–8]", "Springt direkt zur entsprechenden Tab-Position", false, listOf("jump", "tab")),
                    CheatItem("br_last_tab", "Zum letzten Tab springen", "Strg + 9", "Fokussiert immer den am weitesten rechts liegenden Tab", false, listOf("last", "tab")),
                    CheatItem("br_reopen_win", "Geschlossenes Fenster wiederherstellen", "Strg + Shift + N", "Stellt zuletzt geschlossenes Browserfenster mit allen Tabs her", false, listOf("window", "restore")),
                    CheatItem("br_mute_tab", "Tab stummschalten (Firefox)", "Strg + M", "Schaltet Audio im aktiven Tab stumm", false, listOf("mute", "audio"))
                )
            ),
            CheatSection(
                id = "browser_nav",
                title = "Navigation, Lesezeichen & Zoom",
                items = listOf(
                    CheatItem("br_address", "Adressleiste fokussieren", "Strg + L (oder Alt + D)", "Markiert die URL zur schnellen Eingabe", false, listOf("url", "address")),
                    CheatItem("br_search_engine", "Suchmaschine direkt wählen", "URL-Eingabe + Tab", "Sucht z.B. direkt auf Wikipedia oder YouTube", false, listOf("search", "engine")),
                    CheatItem("br_reload", "Seite neu laden", "Strg + R (oder F5)", "Aktualisiert die aktuelle Webseite", false, listOf("reload", "refresh")),
                    CheatItem("br_hard_reload", "Hard Reload (Cache umgehen)", "Strg + F5 / Strg + Shift + R", "Lädt Seite komplett ohne lokalen Cache neu", false, listOf("cache", "hardreload")),
                    CheatItem("br_stop", "Ladevorgang abbrechen", "Esc", "Stoppt das Laden der aktuellen Seite", false, listOf("stop", "abort")),
                    CheatItem("br_bookmark", "Lesezeichen hinzufügen", "Strg + D", "Speichert die aktuelle Seite als Lesezeichen", false, listOf("bookmark", "favorit")),
                    CheatItem("br_bookmark_bar", "Lesezeichenleiste ein-/ausblenden", "Strg + Shift + B", "Blendet die Schnellzugriffsleiste ein oder aus", false, listOf("bookmarks", "bar")),
                    CheatItem("br_history", "Verlauf öffnen", "Strg + H", "Öffnet den Browserverlauf der besuchten Seiten", false, listOf("history", "verlauf")),
                    CheatItem("br_downloads", "Download-Manager öffnen", "Strg + J", "Zeigt Liste aller heruntergeladenen Dateien", false, listOf("downloads", "files")),
                    CheatItem("br_clear_cache", "Browserdaten & Cache leeren", "Strg + Shift + Entf", "Öffnet Dialog zum Löschen von Cookies, Cache & Verlauf", false, listOf("clear", "privacy")),
                    CheatItem("br_find", "Auf der Seite suchen", "Strg + F (oder Strg + G)", "Durchsucht den Text der geladenen Seite", false, listOf("find", "search")),
                    CheatItem("br_zoom_in", "Seite heranzoomen", "Strg + Plus (+)", "Vergrößert Text und Bilder der Seite", false, listOf("zoom", "in")),
                    CheatItem("br_zoom_out", "Seite herauszoomen", "Strg + Minus (-)", "Verkleinert Text und Bilder der Seite", false, listOf("zoom", "out")),
                    CheatItem("br_zoom_reset", "Zoom auf 100 % zurücksetzen", "Strg + 0", "Setzt Zoomfaktor sofort auf Standard zurück", false, listOf("zoom", "reset")),
                    CheatItem("br_fullscreen", "Vollbildmodus umschalten", "F11", "Schaltet Web-Vollbild ohne Browserleisten an/aus", false, listOf("fullscreen", "f11"))
                )
            ),
            CheatSection(
                id = "browser_dev",
                title = "Entwicklerwerkzeuge & Quelltext",
                items = listOf(
                    CheatItem("br_devtools", "Entwicklerwerkzeuge öffnen", "F12 (oder Strg + Shift + I)", "Öffnet DOM-Inspector, Konsole, Netzwerk & Quellen", false, listOf("devtools", "inspect")),
                    CheatItem("br_inspect_elem", "Element direkt untersuchen", "Strg + Shift + C", "Aktiviert Klick-Inspektor für Web-Elemente", false, listOf("inspect", "element")),
                    CheatItem("br_console", "JavaScript Konsole direkt öffnen", "Strg + Shift + J (Chrome) / K (Firefox)", "Öffnet direkt die interaktive JS-Console", false, listOf("console", "js")),
                    CheatItem("br_source", "Seitenquelltext anzeigen", "Strg + U", "Öffnet das rohe HTML-Dokument in neuem Tab", false, listOf("source", "html")),
                    CheatItem("br_device_mode", "Responsive Device Toolbar", "Strg + Shift + M", "Simuliert Smartphones und Tablets in DevTools", false, listOf("responsive", "mobile"))
                )
            )
        )
    )
)
