package com.example.data.repository

import com.example.data.model.CategoryGroup
import com.example.data.model.CategoryIconType
import com.example.data.model.CheatCategory
import com.example.data.model.CheatItem
import com.example.data.model.CheatSection

/**
 * 30+ praxisnahe Shortcuts & Befehle für GitHub/Git, Python, HTML, CSS und Java.
 */
val devCategories: List<CheatCategory> = listOf(
    // -------------------------------------------------------------------------
    // 1. GitHub / Git (31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "github",
        title = "GitHub",
        subtitle = "Git Commands",
        group = CategoryGroup.DEV_TOOLS,
        iconType = CategoryIconType.GITHUB,
        sections = listOf(
            CheatSection(
                id = "git_flow",
                title = "Täglicher Workflow & Commits",
                items = listOf(
                    CheatItem("git_status", "Kompakter Status", "git status -sb", "Zeigt aktuellen Branch und modifizierte Dateien kurz an", true, listOf("status", "branch")),
                    CheatItem("git_commit_am", "Schneller Commit", "git commit -am \"feat: neues feature\"", "Staged geänderte getrackte Dateien und committet sofort", true, listOf("commit", "message")),
                    CheatItem("git_add_all", "Alles stagen", "git add -A", "Fügt alle neuen, geänderten und gelöschten Dateien hinzu", true, listOf("add", "stage")),
                    CheatItem("git_add_patch", "Hunks interaktiv stagen", "git add -p", "Ermöglicht das zeilenweise Auswählen von Code-Änderungen", true, listOf("patch", "interactive")),
                    CheatItem("git_amend", "Letzten Commit erweitern", "git commit --amend --no-edit", "Fügt neue Staged-Dateien dem letzten Commit hinzu", true, listOf("amend", "fix")),
                    CheatItem("git_log_graph", "Grafischer 1-Zeilen Log", "git log --oneline --graph --decorate --all", "ASCII-Graph aller Branches und Commits", true, listOf("log", "graph")),
                    CheatItem("git_diff_staged", "Gestagte Änderungen prüfen", "git diff --staged", "Vergleicht Staging-Area mit dem letzten Commit", true, listOf("diff", "staged")),
                    CheatItem("git_diff_head", "Alle ungesicherten Änderungen", "git diff HEAD", "Zeigt sämtliche Änderungen seit dem letzten Commit an", true, listOf("diff", "head")),
                    CheatItem("git_restore_file", "Datei verwerfen", "git restore <datei>", "Setzt eine Datei auf den Stand des letzten Commits zurück", true, listOf("restore", "discard")),
                    CheatItem("git_restore_staged", "Datei aus Staging entfernen", "git restore --staged <datei>", "Nimmt Datei aus dem Staging ohne Code zu löschen", true, listOf("unstage", "restore")),
                    CheatItem("git_clean", "Nicht getrackte Dateien löschen", "git clean -fd", "Entfernt ungetrackte Dateien und Ordner radikal", true, listOf("clean", "untracked"))
                )
            ),
            CheatSection(
                id = "git_branches",
                title = "Branches, Stash & Rebase",
                items = listOf(
                    CheatItem("git_branch_new", "Neuen Branch erstellen & wechseln", "git checkout -b feat/neuer-branch", "Erstellt einen Branch und switcht direkt hinein", true, listOf("branch", "checkout")),
                    CheatItem("git_switch", "Moderner Branch-Wechsel", "git switch main", "Neuerer, sichererer Befehl zum Wechseln von Branches", true, listOf("switch", "main")),
                    CheatItem("git_branch_del", "Lokalen Branch löschen", "git branch -d <branch_name>", "Löscht einen bereits gemergten lokalen Branch", true, listOf("branch", "delete")),
                    CheatItem("git_branch_force_del", "Branch erzwingend löschen", "git branch -D <branch_name>", "Löscht Branch unabhängig vom Merge-Status", true, listOf("branch", "force")),
                    CheatItem("git_stash_save", "Änderungen temporär sichern", "git stash save -u \"WIP\"", "Speichert unfertige Arbeit inklusive neuer Dateien weg", true, listOf("stash", "save")),
                    CheatItem("git_stash_pop", "Gesicherten Stash anwenden", "git stash pop", "Holt die letzte Arbeit zurück und löscht den Stash", true, listOf("stash", "pop")),
                    CheatItem("git_stash_list", "Alle Stashes auflisten", "git stash list", "Zeigt gespeicherte Stashes mit Datum und Nachricht", true, listOf("stash", "list")),
                    CheatItem("git_rebase_i", "Interaktiver Rebase", "git rebase -i HEAD~3", "Commits squashen, umbenennen oder neu ordnen", true, listOf("rebase", "squash")),
                    CheatItem("git_rebase_abort", "Rebase abbrechen", "git rebase --abort", "Setzt das Repository auf den Zustand vor dem Rebase", true, listOf("rebase", "abort")),
                    CheatItem("git_cherry_pick", "Einzelnen Commit übernehmen", "git cherry-pick <commit-hash>", "Wendet einen Commit aus einem anderen Branch an", true, listOf("cherrypick", "patch"))
                )
            ),
            CheatSection(
                id = "git_remotes",
                title = "Remotes, GitHub CLI & Undo",
                items = listOf(
                    CheatItem("git_push_u", "Branch erstmals pushen", "git push -u origin HEAD", "Pusht aktuellen Branch und richtet Upstream-Tracking ein", true, listOf("push", "upstream")),
                    CheatItem("git_pull_rebase", "Pull mit Rebase statt Merge", "git pull --rebase origin main", "Verhindert unnötige Merge-Commits in der Historie", true, listOf("pull", "rebase")),
                    CheatItem("git_remote_prune", "Gelöschte Branches aufräumen", "git remote prune origin", "Bereinigt verwaiste Tracking-Referenzen lokal", true, listOf("remote", "prune")),
                    CheatItem("git_reset_soft", "Commit zurücknehmen (Code behalten)", "git reset --soft HEAD~1", "Nimmt letzten Commit zurück, lässt Code im Staging", true, listOf("reset", "undo")),
                    CheatItem("git_reset_hard", "Commit & Änderungen verwerfen", "git reset --hard HEAD~1", "Setzt HEAD und Arbeitskopie unwiderruflich zurück", true, listOf("reset", "danger")),
                    CheatItem("git_reflog", "Verlorene Commits retten", "git reflog", "Historie aller HEAD-Bewegungen (Rettungsanker nach Fehlern)", true, listOf("reflog", "rescue")),
                    CheatItem("gh_pr_create", "Pull Request via GitHub CLI", "gh pr create --fill", "Erstellt Pull Request mit Branch-Titel auf GitHub", true, listOf("gh", "pr")),
                    CheatItem("gh_pr_checkout", "PR lokal auschecken", "gh pr checkout <pr_nummer>", "Klont und wechselt auf den Branch eines offenen PRs", true, listOf("gh", "review")),
                    CheatItem("git_tag", "Release Tag erstellen & pushen", "git tag -a v1.0.0 -m \"Release 1.0\" && git push --tags", "Erstellt annotierten Git-Tag für Versionierung", true, listOf("tag", "release")),
                    CheatItem("git_bisect", "Bug per Binärsuche finden", "git bisect start && git bisect bad && git bisect good <commit>", "Findet automatisch den Commit, der den Bug eingeführt hat", true, listOf("bisect", "debug"))
                )
            )
        )
    ),

    // -------------------------------------------------------------------------
    // 2. Python (31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "python",
        title = "Python",
        subtitle = "Syntax & OOP",
        group = CategoryGroup.DEV_TOOLS,
        iconType = CategoryIconType.PYTHON,
        sections = listOf(
            CheatSection(
                id = "py_core",
                title = "Idiome, Data Structures & Comprehensions",
                items = listOf(
                    CheatItem("py_listcomp", "List Comprehension", "[x**2 for x in items if x % 2 == 0]", "Kompakte, performante Transformation und Filterung", true, listOf("list", "filter")),
                    CheatItem("py_dictcomp", "Dict Comprehension", "{k: v for k, v in data.items() if v is not None}", "Filtert Keys/Values deklarativ in ein neues Dictionary", true, listOf("dict", "comprehension")),
                    CheatItem("py_setcomp", "Set Comprehension", "{x.lower() for x in names}", "Erzeugt eine Menge mit eindeutigen Werten", true, listOf("set", "unique")),
                    CheatItem("py_walrus", "Walrus Operator (: =)", "if (n := len(items)) > 10:\n    print(f\"{n} Elemente\")", "Zuweisung innerhalb eines Ausdrucks", true, listOf("syntax", "walrus")),
                    CheatItem("py_fstring", "Formatierter F-String", "f\"Wert: {val:.2f} €, Datum: {dt:%Y-%m-%d}\"", "String-Interpolation mit Formatangaben", true, listOf("string", "format")),
                    CheatItem("py_unpack", "Dictionary Merging (|)", "combined = dict_a | dict_b", "Kombiniert zwei Dictionaries (Python 3.9+)", true, listOf("dict", "merge")),
                    CheatItem("py_enumerate", "Index und Element iterieren", "for idx, val in enumerate(items, start=1):\n    print(idx, val)", "Ermittelt automatisch den Zähler ohne 'i = 0'", true, listOf("loop", "enumerate")),
                    CheatItem("py_zip", "Listen parallel durchlaufen", "for name, score in zip(names, scores):\n    print(name, score)", "Kombiniert mehrere Iterables paarweise", true, listOf("zip", "loop")),
                    CheatItem("py_any_all", "Prüfung mit any() & all()", "if any(x > 100 for x in values):\n    print(\"Überschritten\")", "Gibt True zurück wenn mindestens eines oder alle matchen", true, listOf("any", "all")),
                    CheatItem("py_context", "Context Manager (with)", "with open(\"data.txt\", \"r\", encoding=\"utf-8\") as f:\n    content = f.read()", "Schließt Dateien garantiert auch bei Exceptions", true, listOf("io", "file")),
                    CheatItem("py_generator", "Generator Funktion (yield)", "def count():\n    for i in range(10):\n        yield i * 2", "Speicherschonende Stream-Verarbeitung", true, listOf("generator", "yield"))
                )
            ),
            CheatSection(
                id = "py_oop",
                title = "OOP, Typing & Modern Features",
                items = listOf(
                    CheatItem("py_dataclass", "Dataclass Deklarator", "@dataclass\nclass User:\n    id: int\n    name: str = \"Gast\"", "Erstellt automatisch __init__, __repr__ und __eq__", true, listOf("class", "oop")),
                    CheatItem("py_property", "Property Getter & Setter", "@property\ndef age(self) -> int:\n    return self._age", "Kapselung mit sauberem Pythonischen Attributzugriff", true, listOf("property", "oop")),
                    CheatItem("py_slots", "Speicheroptimierte Klassen", "class Point:\n    __slots__ = ('x', 'y')\n    def __init__(self, x, y):\n        self.x, self.y = x, y", "Spart RAM durch Verzicht auf das __dict__", true, listOf("slots", "performance")),
                    CheatItem("py_typehints", "Type Annotations", "def compute(x: int, y: int) -> float:\n    return float(x / y)", "Statisches Typsystem für IDE-Support und Mypy", true, listOf("types", "hints")),
                    CheatItem("py_union_type", "Moderner Union Type (|)", "def find(query: str) -> User | None:\n    return None", "Union Types ohne Optional/Union Import (3.10+)", true, listOf("types", "union")),
                    CheatItem("py_match", "Structural Pattern Matching", "match command.split():\n    case [\"quit\"]:\n        sys.exit()\n    case [\"go\", dir]:\n        move(dir)", "Mächtiger Switch-Ersatz mit Deconstruction", true, listOf("match", "case")),
                    CheatItem("py_enum", "Typsicheres Enum", "from enum import Enum\nclass Status(Enum):\n    ACTIVE = 1\n    PENDING = 2", "Definiert unveränderliche Namenskonstanten", true, listOf("enum", "types")),
                    CheatItem("py_custom_decorator", "Eigener Funktions-Decorator", "def timer(func):\n    def wrapper(*args, **kwargs):\n        return func(*args, **kwargs)\n    return wrapper", "Modifiziert oder misst Funktionen deklarativ", true, listOf("decorator", "wrapper")),
                    CheatItem("py_args_kwargs", "Variable Argumente entpacken", "def call(*args, **kwargs):\n    func(*args, **kwargs)", "Flexible Parameterübergabe für Listen und Dictionaries", true, listOf("args", "kwargs")),
                    CheatItem("py_dunder_str", "String-Repräsentation", "def __str__(self):\n    return f\"{self.name}\"", "Definiert lesbare Ausgabe für print()", true, listOf("dunder", "magic"))
                )
            ),
            CheatSection(
                id = "py_async_tools",
                title = "AsyncIO, Virtualenv & Tools",
                items = listOf(
                    CheatItem("py_async", "Asynchrone Coroutine", "async def fetch():\n    await asyncio.sleep(1)\n    return \"ok\"", "Nicht-blockierende I/O mit asyncio", true, listOf("async", "await")),
                    CheatItem("py_gather", "Parallele Tasks abwarten", "results = await asyncio.gather(task1(), task2())", "Führt Coroutinen gleichzeitig aus", true, listOf("asyncio", "gather")),
                    CheatItem("py_venv_create", "Virtuelle Umgebung erstellen", "python3 -m venv .venv", "Erstellt isolierte Python-Paketumgebung", true, listOf("venv", "virtualenv")),
                    CheatItem("py_venv_act", "Virtuelle Umgebung aktivieren", "source .venv/bin/activate", "Aktiviert Umgebung in Linux/macOS", true, listOf("venv", "activate")),
                    CheatItem("py_pip_freeze", "Requirements exportieren", "pip freeze > requirements.txt", "Sichert alle installierten Paketversionen", true, listOf("pip", "freeze")),
                    CheatItem("py_pip_install", "Requirements installieren", "pip install -r requirements.txt", "Installiert Abhängigkeiten aus Textdatei", true, listOf("pip", "install")),
                    CheatItem("py_pytest", "Tests ausführen mit Pytest", "pytest -v --cov=app", "Führt Unit-Tests mit Code-Coverage aus", true, listOf("pytest", "test")),
                    CheatItem("py_ruff", "Blazing-Fast Linter (Ruff)", "ruff check . --fix", "Linter und Formatter für sauberen Code", true, listOf("ruff", "lint")),
                    CheatItem("py_json", "JSON parsen und formatieren", "import json\ndata = json.loads(text)\njson_str = json.dumps(data, indent=2)", "Standardbibliothek für JSON-Serialisierung", true, listOf("json", "parse")),
                    CheatItem("py_pathlib", "Moderne Pfad-Operationen", "from pathlib import Path\npath = Path(\"folder\") / \"file.txt\"\npath.write_text(\"content\")", "Objektorientierte Dateioperationen", true, listOf("pathlib", "file"))
                )
            )
        )
    ),

    // -------------------------------------------------------------------------
    // 3. HTML (31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "html",
        title = "HTML",
        subtitle = "Tags & Attribute",
        group = CategoryGroup.DEV_TOOLS,
        iconType = CategoryIconType.HTML,
        sections = listOf(
            CheatSection(
                id = "html_doc",
                title = "Dokumentenstruktur, Head & SEO",
                items = listOf(
                    CheatItem("html_meta_viewport", "Mobile Viewport Meta-Tag", "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">", "Unerlässlich für responsive Webseiten", true, listOf("viewport", "mobile")),
                    CheatItem("html_charset", "Zeichensatz Deklaration", "<meta charset=\"UTF-8\">", "Definiert UTF-8 für Sonderzeichen und Umlaute", true, listOf("charset", "utf8")),
                    CheatItem("html_meta_desc", "Meta Description für Google", "<meta name=\"description\" content=\"Kurze Seitenbeschreibung (155 Zeichen)\">", "SEO Snippet in Suchmaschinenergebnissen", true, listOf("seo", "meta")),
                    CheatItem("html_canonical", "Canonical URL", "<link rel=\"canonical\" href=\"https://domain.com/seite\">", "Verhindert Duplicate Content Strafen bei Suchmaschinen", true, listOf("canonical", "seo")),
                    CheatItem("html_favicon", "Modernes SVG Favicon", "<link rel=\"icon\" type=\"image/svg+xml\" href=\"/favicon.svg\">", "Scharfes, skalierbares Icon im Browser-Tab", true, listOf("favicon", "icon")),
                    CheatItem("html_semantic_main", "Semantische Haupttags", "<header>, <nav>, <main>, <article>, <section>, <aside>, <footer>", "Strukturiert Dokumente zugänglich und suchmaschinenfreundlich", true, listOf("semantic", "seo")),
                    CheatItem("html_figure", "Abbildung mit Bildunterschrift", "<figure>\n  <img src=\"chart.png\" alt=\"Diagramm\">\n  <figcaption>Umsatzstatistik 2026</figcaption>\n</figure>", "Semantische Kapselung von Grafiken und Tabellen", true, listOf("figure", "caption")),
                    CheatItem("html_dialog", "Natives Modal Dialog", "<dialog id=\"modal\">\n  <button onclick=\"this.parentElement.close()\">Schließen</button>\n</dialog>", "Moderne, barrierefreie Modals ohne externes JS", true, listOf("dialog", "modal")),
                    CheatItem("html_details", "Natives Akkordeon / Dropdown", "<details>\n  <summary>Häufige Fragen</summary>\n  <p>Antwort hier...</p>\n</details>", "Aufklappbarer Bereich ganz ohne JavaScript", true, listOf("details", "summary")),
                    CheatItem("html_template", "Wiederverwendbare DOM-Vorlage", "<template id=\"user-row\">\n  <div class=\"user-card\"></div>\n</template>", "Wird nicht gerendert bis es per JS geklont wird", true, listOf("template", "dom"))
                )
            ),
            CheatSection(
                id = "html_forms",
                title = "Formulare & Input-Validierung",
                items = listOf(
                    CheatItem("html_input_email", "Email mit Pflichtfeld", "<input type=\"email\" required placeholder=\"name@domain.de\">", "Automatische Validierung vor dem Absenden", true, listOf("input", "email")),
                    CheatItem("html_input_pattern", "Regex-Muster Validierung", "<input type=\"text\" pattern=\"[A-Z]{3}-[0-9]{4}\" title=\"Format: ABC-1234\">", "Prüft Eingaben gegen reguläre Ausdrücke", true, listOf("pattern", "regex")),
                    CheatItem("html_datalist", "Autocomplete Datalist", "<input list=\"distros\">\n<datalist id=\"distros\">\n  <option value=\"Arch\">\n  <option value=\"Fedora\">\n</datalist>", "Eingabefeld mit nativer Dropdown-Vorschlagsliste", true, listOf("datalist", "autocomplete")),
                    CheatItem("html_input_date", "Nativer Datepicker", "<input type=\"date\" min=\"2026-01-01\" max=\"2026-12-31\">", "Kalenderauswahl mit Begrenzung", true, listOf("date", "picker")),
                    CheatItem("html_input_range", "Schieberegler (Slider)", "<input type=\"range\" min=\"0\" max=\"100\" step=\"5\" value=\"50\">", "Nativer numerischer Schieberegler", true, listOf("range", "slider")),
                    CheatItem("html_input_file", "Dateiupload mit Filter", "<input type=\"file\" accept=\"image/png, image/jpeg\" multiple>", "Filtert erlaubte Dateitypen beim Auswählen", true, listOf("file", "upload")),
                    CheatItem("html_input_color", "Farbwähler (Colorpicker)", "<input type=\"color\" value=\"#84b0ae\">", "Öffnet den nativen Farbauswahldialog", true, listOf("color", "picker")),
                    CheatItem("html_label_for", "Barrierefreies Label-Binding", "<label for=\"username\">Benutzer:</label>\n<input id=\"username\" type=\"text\">", "Fokussiert Eingabefeld bei Klick auf den Text", true, listOf("label", "a11y")),
                    CheatItem("html_fieldset", "Formulargruppen", "<fieldset>\n  <legend>Zahlungsart</legend>\n  <input type=\"radio\" name=\"pay\" id=\"card\">\n</fieldset>", "Semantische Gruppierung von Formularoptionen", true, listOf("fieldset", "form")),
                    CheatItem("html_button_type", "Button-Typen explizit definieren", "<button type=\"button\">Klick</button>\n<button type=\"submit\">Senden</button>", "Verhindert ungewolltes Absenden des Formulars", true, listOf("button", "type"))
                )
            ),
            CheatSection(
                id = "html_media_a11y",
                title = "Medien & Accessibility (ARIA)",
                items = listOf(
                    CheatItem("html_picture", "Responsives WebP / AVIF Bild", "<picture>\n  <source srcset=\"hero.avif\" type=\"image/avif\">\n  <source srcset=\"hero.webp\" type=\"image/webp\">\n  <img src=\"hero.jpg\" alt=\"Hero Banner\">\n</picture>", "Liefert moderne Bildformate basierend auf Support", true, listOf("picture", "webp")),
                    CheatItem("html_lazy", "Natives Lazy Loading", "<img src=\"foto.jpg\" loading=\"lazy\" alt=\"Beschreibung\">", "Lädt Bilder erst kurz vor Sichtbarkeit im Viewport", true, listOf("lazy", "performance")),
                    CheatItem("html_video", "Nativer Video-Player", "<video controls poster=\"cover.jpg\" preload=\"metadata\">\n  <source src=\"video.mp4\" type=\"video/mp4\">\n</video>", "Video-Player mit Coverbild und Steuerung", true, listOf("video", "media")),
                    CheatItem("html_audio", "Nativer Audio-Player", "<audio controls src=\"track.mp3\"></audio>", "Spielt Sounddateien direkt mit nativen Controls", true, listOf("audio", "media")),
                    CheatItem("html_aria_label", "ARIA Label für Icon-Buttons", "<button aria-label=\"Einstellungen öffnen\"><svg>...</svg></button>", "Screenreader-Name für reine Icon-Schaltflächen", true, listOf("aria", "a11y")),
                    CheatItem("html_aria_expanded", "Akkordeon Zustand", "<button aria-expanded=\"false\" aria-controls=\"menu-1\">Menü</button>", "Signalisiert Screenreadern ob Bereich offen/zu ist", true, listOf("aria", "expanded")),
                    CheatItem("html_sr_only", "Visuell versteckter Hilfstext", "<span class=\"sr-only\">Öffnet in neuem Fenster</span>", "Informiert Sehbehinderte ohne Design zu stören", true, listOf("sronly", "a11y")),
                    CheatItem("html_role", "Explizite ARIA Rollen", "<div role=\"alert\">Fehler beim Speichern!</div>", "Gibt Statusmeldungen sofort an Screenreader aus", true, listOf("role", "alert")),
                    CheatItem("html_time", "Semantische Zeitangabe", "<time datetime=\"2026-10-27\">27. Oktober 2026</time>", "Maschinenlesbare Datumsangabe für Crawler", true, listOf("time", "date")),
                    CheatItem("html_script_defer", "Skripte nicht-blockierend laden", "<script src=\"app.js\" defer></script>", "Führt JS erst nach vollständigem HTML-Parsing aus", true, listOf("script", "defer")),
                    CheatItem("html_preload", "Schriftart vorab laden", "<link rel=\"preload\" href=\"/fonts/font.woff2\" as=\"font\" type=\"font/woff2\" crossorigin>", "Verhindert Layout-Shift (CLS) beim Laden von Webfonts", true, listOf("preload", "fonts"))
                )
            )
        )
    ),

    // -------------------------------------------------------------------------
    // 4. CSS (Flexbox & Grid - 31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "css",
        title = "CSS",
        subtitle = "Flexbox & Grid",
        group = CategoryGroup.DEV_TOOLS,
        iconType = CategoryIconType.CSS,
        sections = listOf(
            CheatSection(
                id = "css_flex_grid",
                title = "Flexbox & CSS Grid Layouts",
                items = listOf(
                    CheatItem("css_center", "Perfekt zentrieren (Flexbox)", "display: flex;\njustify-content: center;\nalign-items: center;", "Der absolute Standard für horizontale & vertikale Zentrierung", true, listOf("center", "flex")),
                    CheatItem("css_flex_space", "Elemente außen anordnen", "display: flex;\njustify-content: space-between;\nalign-items: center;", "Typisches Muster für Navigationsleisten & Header", true, listOf("flex", "space")),
                    CheatItem("css_flex_wrap", "Flexbox Zeilenumbruch", "display: flex;\nflex-wrap: wrap;\ngap: 1rem;", "Bricht Tags oder Chips automatisch in neue Zeilen um", true, listOf("wrap", "gap")),
                    CheatItem("css_flex_grow", "Verfügbaren Platz füllen", "flex: 1 1 auto;", "Lässt Kindelement den verbleibenden Freiraum einnehmen", true, listOf("flex", "grow")),
                    CheatItem("css_grid_auto", "Responsives Grid ohne Media Queries", "display: grid;\ngrid-template-columns: repeat(auto-fit, minmax(240px, 1fr));\ngap: 1.5rem;", "Bricht Kacheln automatisch flüssig um", true, listOf("grid", "responsive")),
                    CheatItem("css_grid_center", "Zentrieren mit 2 Zeilen Grid", "display: grid;\nplace-items: center;", "Kürzeste Methode für perfekte Elementzentrierung", true, listOf("grid", "center")),
                    CheatItem("css_grid_areas", "Benannte Rasterbereiche (Areas)", "grid-template-areas:\n  \"header header\"\n  \"sidebar content\"\n  \"footer footer\";", "Lesbare Desktop-Seitenlayouts", true, listOf("grid", "areas")),
                    CheatItem("css_subgrid", "CSS Subgrid", "grid-template-rows: subgrid;", "Vererbt Zeilenraster an Kindelemente für identische Höhen", true, listOf("subgrid", "grid")),
                    CheatItem("css_aspect", "Seitenverhältnis erzwingen", "aspect-ratio: 16 / 9;\nwidth: 100%;", "Hält Bild- oder Videoverhältnisse ohne Padding-Hacks", true, listOf("aspect", "ratio")),
                    CheatItem("css_container", "Container Queries", "@container (min-width: 400px) {\n  .card { flex-direction: row; }\n}", "Reagiert auf die Breite der Elternbox statt des Bildschirms", true, listOf("container", "queries"))
                )
            ),
            CheatSection(
                id = "css_modern_visuals",
                title = "Glassmorphismus, Variablen & Effekte",
                items = listOf(
                    CheatItem("css_vars", "CSS Custom Properties (Variablen)", ":root {\n  --accent: #84B0AE;\n}\ncolor: var(--accent);", "Zentrale Steuerung für Farbschemata und Abstände", true, listOf("variables", "tokens")),
                    CheatItem("css_glass", "Frosted Glass Effekt", "background: rgba(11, 43, 54, 0.65);\nbackdrop-filter: blur(16px);\n-webkit-backdrop-filter: blur(16px);\nborder: 1px solid rgba(255, 255, 255, 0.2);", "Glassmorphismus-Effekt mit Weichzeichnung dahinter", true, listOf("blur", "glass")),
                    CheatItem("css_clamp", "Flüssige Schriftgröße (clamp)", "font-size: clamp(1rem, 2.5vw, 2.2rem);", "Passt Schriftgrößen stufenlos der Bildschirmbreite an", true, listOf("typography", "clamp")),
                    CheatItem("css_truncate", "Text mit Auslassungspunkten", "white-space: nowrap;\noverflow: hidden;\ntext-overflow: ellipsis;", "Kürzt überlangen Text sauber mit '...' ab", true, listOf("truncate", "ellipsis")),
                    CheatItem("css_line_clamp", "Mehrzeiliger Text-Clamp", "display: -webkit-box;\n-webkit-line-clamp: 3;\n-webkit-box-orient: vertical;\noverflow: hidden;", "Begrenzt Fließtext exakt auf 3 Zeilen", true, listOf("clamp", "lines")),
                    CheatItem("css_snap", "Scroll-Snap Karussell", "scroll-snap-type: x mandatory;\nscroll-snap-align: center;", "Magnetisches Einrasten von Elementen beim horizontalen Wischen", true, listOf("snap", "scroll")),
                    CheatItem("css_accent", "Formular-Akzentfarbe anpassen", "accent-color: #84B0AE;", "Färbt native Checkboxen, Slider und Radio-Buttons ein", true, listOf("accent", "forms")),
                    CheatItem("css_gradient_text", "Text mit Farbverlauf", "background: linear-gradient(90deg, #84B0AE, #CFD5D7);\n-webkit-background-clip: text;\n-webkit-text-fill-color: transparent;", "Färbt Überschriften mit weichem Farbverlauf", true, listOf("gradient", "text")),
                    CheatItem("css_box_shadow", "Weicher Schattenwurf", "box-shadow: 0 10px 25px -5px rgba(0, 0, 0, 0.3);", "Mehrstufiger Schatten für realistische Tiefe", true, listOf("shadow", "elevation")),
                    CheatItem("css_pointer_events", "Klicks ignorieren", "pointer-events: none;", "Lässt Mausklicks durch dekorative Overlays hindurch", true, listOf("pointer", "events")),
                    CheatItem("css_user_select", "Textmarkierung sperren", "user-select: none;", "Verhindert versehentliches Markieren auf Schaltflächen", true, listOf("select", "touch"))
                )
            ),
            CheatSection(
                id = "css_resets_media",
                title = "Resets, Media Queries & Animationen",
                items = listOf(
                    CheatItem("css_box_sizing", "Standard Box-Sizing Reset", "*, *::before, *::after {\n  box-sizing: border-box;\n  margin: 0;\n  padding: 0;\n}", "Verhindert Layout-Verschiebungen durch Padding", true, listOf("reset", "boxsizing")),
                    CheatItem("css_dark_mode", "Dark Mode via System-Präferenz", "@media (prefers-color-scheme: dark) {\n  body {\n    background: #09151E;\n    color: #CFD5D7;\n  }\n}", "Reagiert nativ auf Systemeinstellungen des Nutzers", true, listOf("darkmode", "media")),
                    CheatItem("css_reduced_motion", "Barrierefreie Animationen", "@media (prefers-reduced-motion: reduce) {\n  * { animation-duration: 0.01ms !important; }\n}", "Schützt Nutzer vor Schwindel durch Bewegungseffekte", true, listOf("a11y", "motion")),
                    CheatItem("css_transitions", "Flüssige Hover-Transition", "transition: transform 0.2s ease, opacity 0.2s ease;", "Vermeidet ruckartige Zustandswechsel", true, listOf("transition", "hover")),
                    CheatItem("css_keyframe", "CSS Keyframe Animation", "@keyframes pulse {\n  0%, 100% { opacity: 1; }\n  50% { opacity: 0.5; }\n}\nanimation: pulse 2s infinite ease-in-out;", "Endlosschleife für pulsierende Badges", true, listOf("animation", "keyframes")),
                    CheatItem("css_has_selector", "Parent Selector (:has)", "article:has(img) {\n  grid-template-columns: 1fr 2fr;\n}", "Stylt Elternbox abhängig von vorhandenen Kindelementen", true, listOf("has", "selector")),
                    CheatItem("css_is_where", "Gruppierte Selektoren (:is / :where)", ":is(h1, h2, h3):hover {\n  color: var(--accent);\n}", "Kompaktes und sauberes Bündeln von Styles", true, listOf("is", "where")),
                    CheatItem("css_sticky", "Sticky Header", "position: sticky;\ntop: 0;\nz-index: 100;", "Bleibt beim Herunterscrollen oben am Bildschirmrand haften", true, listOf("sticky", "header")),
                    CheatItem("css_scrollbar", "Scrollbalken dezent stylen", "::-webkit-scrollbar {\n  width: 6px;\n}\n::-webkit-scrollbar-thumb {\n  background: #527276;\n  border-radius: 3px;\n}", "Minimalistischer, eleganter Scrollbar-Look", true, listOf("scrollbar", "style")),
                    CheatItem("css_font_feature", "Tabellenzahlen feste Breite", "font-variant-numeric: tabular-nums;", "Zahlen tanzen beim Wechseln von Beträgen nicht hin und her", true, listOf("numbers", "font"))
                )
            )
        )
    ),

    // -------------------------------------------------------------------------
    // 5. Java (31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "java",
        title = "Java",
        subtitle = "Syntax & OOP",
        group = CategoryGroup.DEV_TOOLS,
        iconType = CategoryIconType.JAVA,
        sections = listOf(
            CheatSection(
                id = "java_modern",
                title = "Moderne Java Features (17–21+)",
                items = listOf(
                    CheatItem("java_record", "Record (Unveränderliche DTOs)", "public record User(Long id, String name, String email) {}", "Erzeugt Konstruktor, Getter, equals, hashCode und toString", true, listOf("record", "dto")),
                    CheatItem("java_stream", "Stream Filter & Mapping", "List<String> active = users.stream()\n    .filter(User::isActive)\n    .map(User::getName)\n    .toList();", "Deklarative Datenverarbeitung", true, listOf("stream", "functional")),
                    CheatItem("java_switch", "Pattern Matching Switch", "String res = switch (obj) {\n    case Integer i -> \"Zahl: \" + i;\n    case String s  -> \"Text: \" + s;\n    default        -> \"Unbekannt\";\n};", "Typprüfung und Zuweisung in einem Ausdruck", true, listOf("switch", "pattern")),
                    CheatItem("java_instanceof", "Pattern Matching instanceof", "if (obj instanceof String s && s.length() > 5) {\n    System.out.println(s.toUpperCase());\n}", "Macht manuelles Type-Casting überflüssig", true, listOf("instanceof", "cast")),
                    CheatItem("java_textblocks", "Multiline Text Blocks", "String json = \"\"\"\n    {\n      \"status\": \"success\"\n    }\n    \"\"\";", "Saubere mehrzeilige Strings ohne Escape-Zeichen", true, listOf("string", "textblocks")),
                    CheatItem("java_var", "Lokale Typinferenz (var)", "var list = new ArrayList<Map<String, User>>();", "Reduziert Boilerplate-Code bei lokalen Variablen", true, listOf("var", "inference")),
                    CheatItem("java_optional", "Nullsicheres Optional", "String email = Optional.ofNullable(user)\n    .map(User::email)\n    .orElse(\"keine@domain.de\");", "Verhindert NullPointerExceptions elegant", true, listOf("optional", "nullsafety")),
                    CheatItem("java_sealed", "Sealed Interfaces", "public sealed interface Result permits Success, Failure {}", "Begrenzt Implementierungen auf definierte Klassen", true, listOf("sealed", "algebraic")),
                    CheatItem("java_try_res", "Try-with-Resources", "try (var in = new FileInputStream(\"file.txt\")) {\n    in.read();\n}", "Schließt Streams und Sockets automatisch", true, listOf("try", "autoclose")),
                    CheatItem("java_virtual_threads", "Virtuelle Threads (Project Loom)", "Thread.startVirtualThread(() -> {\n    handleRequest();\n});", "Leichtgewichtige Millionen Threads für Hochdurchsatz", true, listOf("loom", "threads")),
                    CheatItem("java_format", "Formatierte Strings", "String msg = String.format(\"Hallo %s, Betrag: %.2f €\", name, amount);", "Präzise Zahlen- und Textausgabe", true, listOf("format", "string"))
                )
            ),
            CheatSection(
                id = "java_collections",
                title = "Collections & Functional Programming",
                items = listOf(
                    CheatItem("java_list_of", "Unveränderliche Liste", "List<String> items = List.of(\"A\", \"B\", \"C\");", "Kompakte, read-only Liste (Java 9+)", true, listOf("list", "immutable")),
                    CheatItem("java_map_of", "Unveränderliche Map", "Map<String, Integer> map = Map.of(\"Eins\", 1, \"Zwei\", 2);", "Inline Map-Initialisierung", true, listOf("map", "immutable")),
                    CheatItem("java_stream_reduce", "Stream Summe mit Reduce", "int sum = numbers.stream().reduce(0, Integer::sum);", "Aggregiert Stream-Elemente zu einem Gesamtwert", true, listOf("stream", "reduce")),
                    CheatItem("java_stream_group", "Gruppieren mit Collectors", "Map<Department, List<Employee>> byDept = employees.stream()\n    .collect(Collectors.groupingBy(Employee::department));", "Gruppiert Objekte nach Attributen", true, listOf("grouping", "collectors")),
                    CheatItem("java_stream_flatmap", "Listen verschachteln (flatMap)", "List<Item> all = orders.stream()\n    .flatMap(o -> o.items().stream())\n    .toList();", "Plättet verschachtelte Listen in einen flachen Stream", true, listOf("flatmap", "stream")),
                    CheatItem("java_comparator", "Moderne Comparator Chaining", "list.sort(Comparator.comparing(User::lastName)\n    .thenComparing(User::firstName));", "Mehrstufige Sortierung ohne anonyme Klassen", true, listOf("comparator", "sort")),
                    CheatItem("java_completable_future", "Asynchrone Futures", "CompletableFuture.supplyAsync(() -> fetchRemoteData())\n    .thenAccept(this::processResult);", "Nicht-blockierende Hintergrundverarbeitung", true, listOf("future", "async")),
                    CheatItem("java_concurrent_map", "Thread-sichere Map", "ConcurrentMap<String, String> cache = new ConcurrentHashMap<>();", "Sicherer Mehrthread-Zugriff ohne globale Locks", true, listOf("concurrency", "map")),
                    CheatItem("java_predicate", "Wiederverwendbare Prädikate", "Predicate<User> isAdult = u -> u.age() >= 18;\nusers.removeIf(isAdult.negate());", "Kombinierbare Filterbedingungen", true, listOf("predicate", "functional"))
                )
            ),
            CheatSection(
                id = "java_jvm_tools",
                title = "JVM, IO & Best Practices",
                items = listOf(
                    CheatItem("java_files_read", "Datei in String einlesen", "String content = Files.readString(Path.of(\"file.txt\"));", "Schnellste Methode zum Lesen von Textdateien (Java 11+)", true, listOf("files", "io")),
                    CheatItem("java_files_write", "String in Datei schreiben", "Files.writeString(Path.of(\"output.txt\"), content);", "Schreibt Datei atomar und sauber", true, listOf("files", "write")),
                    CheatItem("java_http_client", "Moderner HTTP Client", "HttpClient client = HttpClient.newHttpClient();\nHttpRequest req = HttpRequest.newBuilder(URI.create(url)).build();\nHttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());", "Nativer HTTP/2 Client ohne Drittbibliotheken", true, listOf("http", "client")),
                    CheatItem("java_big_decimal", "Finanz-Berechnungen", "BigDecimal val = new BigDecimal(\"19.99\").multiply(new BigDecimal(\"1.19\"));", "Verhindert Rundungsfehler von IEEE 754 Floats", true, listOf("bigdecimal", "money")),
                    CheatItem("java_instant", "UTC Zeitstempel (Instant)", "Instant now = Instant.now();\nlong epochMs = now.toEpochMilli();", "Präzise UTC-Zeitpunkte ohne Zeitzonen-Fallstricke", true, listOf("time", "instant")),
                    CheatItem("java_duration", "Zeitabstände berechnen", "Duration diff = Duration.between(start, finish);\nSystem.out.println(diff.toSeconds());", "Berechnet Differenz zweier Zeitpunkte", true, listOf("duration", "time")),
                    CheatItem("java_regex", "Reguläre Ausdrücke (Pattern)", "Pattern p = Pattern.compile(\"\\\\d+\");\nMatcher m = p.matcher(\"Nr: 42\");", "Effizientes Kompilieren von Suchmustern", true, listOf("regex", "pattern")),
                    CheatItem("java_assert_throws", "JUnit 5 Exception-Test", "assertThrows(IllegalArgumentException.class, () -> {\n    service.calculate(-1);\n});", "Prüft ob definierte Ausnahme geworfen wird", true, listOf("junit", "test")),
                    CheatItem("java_string_join", "Strings verbinden", "String joined = String.join(\", \", list);", "Verbindet Liste mit Trennzeichen", true, listOf("string", "join")),
                    CheatItem("java_equals_hashcode", "Objects.hash Helfer", "Objects.hash(id, name, email);", "Berechnet sauberen HashCode für mehrere Felder", true, listOf("hashcode", "objects"))
                )
            )
        )
    )
)
