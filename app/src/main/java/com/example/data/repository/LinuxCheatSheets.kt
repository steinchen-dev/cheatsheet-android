package com.example.data.repository

import com.example.data.model.CategoryGroup
import com.example.data.model.CategoryIconType
import com.example.data.model.CheatCategory
import com.example.data.model.CheatItem
import com.example.data.model.CheatSection

/**
 * 30+ praxisnahe Shortcuts & Befehle für Linux Allgemein, Arch, Fedora, Mint, Hyprland und KDE Plasma.
 */
val linuxCategories: List<CheatCategory> = listOf(
    // -------------------------------------------------------------------------
    // 1. Linux Allgemein (31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "linux",
        title = "Linux",
        subtitle = "Shell-Befehle",
        group = CategoryGroup.LINUX_DESKTOP,
        iconType = CategoryIconType.LINUX,
        sections = listOf(
            CheatSection(
                id = "lin_files",
                title = "Dateimanagement & Suchen",
                items = listOf(
                    CheatItem("lin_ls", "Detailliertes Verzeichnis", "ls -lha", "Listet alle Dateien inkl. Rechten, Besitzern & versteckten Dateien", true, listOf("file", "dir")),
                    CheatItem("lin_grep", "Rekursive Volltextsuche", "grep -rnI \"Muster\" .", "Durchsucht alle Textdateien unter Vermeidung von Binärdaten", true, listOf("search", "text")),
                    CheatItem("lin_find_name", "Dateien nach Name suchen", "find /pfad -type f -name \"*.conf\"", "Findet Dateien nach Dateiendung oder Mustern", true, listOf("find", "name")),
                    CheatItem("lin_find_mtime", "Zuletzt geänderte Dateien", "find . -type f -mtime -2", "Listet alle Dateien auf, die in den letzten 48h geändert wurden", true, listOf("find", "time")),
                    CheatItem("lin_find_size", "Große Dateien finden", "find / -type f -size +100M 2>/dev/null", "Findet Dateien größer als 100 Megabyte systemweit", true, listOf("find", "size")),
                    CheatItem("lin_tar_extract", "Tar.gz Archiv entpacken", "tar -xzvf archiv.tar.gz", "Entpackt gzipptes Tar-Archiv mit Statusanzeige", true, listOf("unzip", "tar")),
                    CheatItem("lin_tar_create", "Tar.gz Archiv erstellen", "tar -czvf archiv.tar.gz /ordner", "Komprimiert ein Verzeichnis in ein gzip-Archiv", true, listOf("tar", "compress")),
                    CheatItem("lin_rsync", "Dateien synchronisieren mit Fortschritt", "rsync -avzP /quelle/ /ziel/", "Effizientes Kopieren über SSH oder lokal mit Resuming", true, listOf("rsync", "copy")),
                    CheatItem("lin_chmod", "Dateirechte rekursiv anpassen", "chmod -R 755 /pfad", "Setzt Rechte (rwxr-xr-x) auf Verzeichnisse", true, listOf("chmod", "rights")),
                    CheatItem("lin_chown", "Besitzer rekursiv ändern", "chown -R user:group /pfad", "Weist Dateien einem neuen Benutzer und Gruppe zu", true, listOf("chown", "owner")),
                    CheatItem("lin_tree", "Verzeichnisbaum visualisieren", "tree -L 2", "Zeigt Verzeichnisstruktur übersichtlich bis Ebene 2", true, listOf("tree", "dir"))
                )
            ),
            CheatSection(
                id = "lin_sys",
                title = "Speicher, Prozesse & Systemstatus",
                items = listOf(
                    CheatItem("lin_df", "Speicherplatz der Partitionen", "df -h", "Zeigt Festplattenauslastung in lesbarem GB/MB Format", true, listOf("disk", "storage")),
                    CheatItem("lin_du", "Größte Ordner aufspüren", "du -sh * | sort -h", "Berechnet Ordnergrößen und sortiert aufsteigend", true, listOf("du", "storage")),
                    CheatItem("lin_free", "RAM-Auslastung prüfen", "free -h", "Zeigt belegten, freien und Cache-Arbeitsspeicher an", true, listOf("ram", "memory")),
                    CheatItem("lin_top", "Prozessmonitor", "htop (oder top)", "Interaktiver Taskmanager für CPU- und RAM-Last", true, listOf("top", "htop")),
                    CheatItem("lin_ps", "Laufende Prozesse filtern", "ps aux | grep <name>", "Listet Details aller Prozesse inklusive PID und Status", true, listOf("ps", "process")),
                    CheatItem("lin_kill", "Prozess sofort beenden", "kill -9 <PID>", "Sendet unübersteuerbares SIGKILL an Prozess", true, listOf("kill", "sigkill")),
                    CheatItem("lin_killall", "Prozess nach Namen beenden", "killall -9 <prozessname>", "Beendet alle Instanzen eines Prozesses", true, listOf("killall", "process")),
                    CheatItem("lin_pkill", "Pattern-basiertes Beenden", "pkill -f <suchmuster>", "Findet und beendet Prozesse anhand von Kommandozeilen", true, listOf("pkill", "kill")),
                    CheatItem("lin_uptime", "Laufzeit & Load Average", "uptime", "Zeigt wie lange das System läuft und die Last der letzten 15min", true, listOf("uptime", "load")),
                    CheatItem("lin_uname", "Kernel & Architektur", "uname -r -m", "Gibt Linux-Kernel-Version und CPU-Architektur aus", true, listOf("kernel", "arch")),
                    CheatItem("lin_tail", "Logfiles live mitlesen", "tail -f /var/log/syslog", "Zeigt neue Zeilen in Logdateien in Echtzeit an", true, listOf("tail", "log")),
                    CheatItem("lin_journal", "Service Logs via Systemd", "journalctl -xeu <service>", "Detailliertes Fehlerprotokoll einer systemd-Einheit", true, listOf("journalctl", "systemd")),
                    CheatItem("lin_dmesg", "Kernel Boot & Hardware-Meldungen", "dmesg -T --level=err,warn", "Zeigt Hardware- und Treiberwarnungen mit Zeitstempel", true, listOf("dmesg", "hardware"))
                )
            ),
            CheatSection(
                id = "lin_shortcuts",
                title = "Bash & Terminal Hotkeys",
                items = listOf(
                    CheatItem("lin_ctrl_c", "Laufenden Befehl abbrechen", "Strg + C", "Sendet SIGINT und stoppt den aktuellen Vordergrundprozess", false, listOf("cancel", "sigint")),
                    CheatItem("lin_ctrl_z", "Befehl in den Hintergrund schicken", "Strg + Z", "Pausiert Prozess; Fortsetzen mit 'fg' oder 'bg'", false, listOf("suspend", "bg")),
                    CheatItem("lin_ctrl_r", "Befehlshistorie rückwärts durchsuchen", "Strg + R", "Tippen zum Suchen in vergangenen Terminalbefehlen", false, listOf("history", "search")),
                    CheatItem("lin_ctrl_l", "Terminal leeren", "Strg + L", "Leert das Terminalfenster (entspricht 'clear')", false, listOf("clear", "terminal")),
                    CheatItem("lin_ctrl_a", "Zum Zeilenanfang springen", "Strg + A", "Bewegt den Cursor an den Anfang der Befehlszeile", false, listOf("cursor", "begin")),
                    CheatItem("lin_ctrl_e", "Zum Zeilenende springen", "Strg + E", "Bewegt den Cursor an das Ende der Befehlszeile", false, listOf("cursor", "end")),
                    CheatItem("lin_ctrl_u", "Zeile vor dem Cursor löschen", "Strg + U", "Löscht den gesamten Text links vom Cursor", false, listOf("delete", "line"))
                )
            )
        )
    ),

    // -------------------------------------------------------------------------
    // 2. Arch Linux (31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "arch",
        title = "Arch",
        subtitle = "Pacman & System",
        group = CategoryGroup.LINUX_DESKTOP,
        iconType = CategoryIconType.ARCH,
        sections = listOf(
            CheatSection(
                id = "arch_pacman",
                title = "Pacman Paketmanagement",
                items = listOf(
                    CheatItem("arch_sync", "Komplettes System-Update", "sudo pacman -Syu", "Synchronisiert Repositories und aktualisiert alle Pakete", true, listOf("update", "upgrade")),
                    CheatItem("arch_install", "Paket installieren", "sudo pacman -S <paket>", "Lädt und installiert Software aus den Repositories", true, listOf("install", "software")),
                    CheatItem("arch_remove", "Paket inkl. ungenutzter Abhängigkeiten", "sudo pacman -Rns <paket>", "Entfernt Paket, Konfigurationen und verwaiste Pakete", true, listOf("remove", "purge")),
                    CheatItem("arch_search", "In Repositories suchen", "pacman -Ss <suchbegriff>", "Durchsucht Paketbeschreibungen nach Schlüsselwörtern", true, listOf("search", "find")),
                    CheatItem("arch_info", "Paketinformationen abrufen", "pacman -Si <paket>", "Zeigt Abhängigkeiten, Lizenz und Downloadgröße an", true, listOf("info", "details")),
                    CheatItem("arch_local_search", "Installierte Pakete filtern", "pacman -Qs <begriff>", "Sucht nur in lokal bereits installierter Software", true, listOf("local", "installed")),
                    CheatItem("arch_files", "Dateien eines Pakets auflisten", "pacman -Ql <paket>", "Zeigt alle vom Paket installierten Dateipfade an", true, listOf("files", "list")),
                    CheatItem("arch_owner", "Zu welchem Paket gehört Datei?", "pacman -Qo /pfad/zur/datei", "Ermittelt das Paket, aus dem eine Datei stammt", true, listOf("owner", "file")),
                    CheatItem("arch_orphans", "Verwaiste Pakete finden & löschen", "sudo pacman -Rns $(pacman -Qtdq)", "Befreit das System von ungenutzten Abhängigkeiten", true, listOf("clean", "orphans")),
                    CheatItem("arch_paccache", "Alte Paket-Caches bereinigen", "sudo paccache -r", "Behält nur die letzten 3 Versionen im Cache", true, listOf("cache", "paccache")),
                    CheatItem("arch_clean_all", "Gesamten Cache leeren", "sudo pacman -Scc", "Löscht den gesamten Download-Cache im Dateisystem", true, listOf("cache", "clean")),
                    CheatItem("arch_explicit", "Explizit installierte Pakete auflisten", "pacman -Qe", "Listet nur selbst gewählte Programme auf", true, listOf("installed", "explicit"))
                )
            ),
            CheatSection(
                id = "arch_aur",
                title = "AUR & Yay Helper",
                items = listOf(
                    CheatItem("arch_yay_update", "System & AUR komplett updaten", "yay -Syu", "Aktualisiert offizielle Repositories UND das AUR", true, listOf("yay", "aur")),
                    CheatItem("arch_yay_install", "AUR Paket installieren", "yay -S <aur-paket>", "Kompiliert und installiert Software aus dem AUR", true, listOf("aur", "yay")),
                    CheatItem("arch_yay_clean", "AUR Build-Caches leeren", "yay -Sc", "Löscht temporäre Git-Repositories und Builds", true, listOf("clean", "yay")),
                    CheatItem("arch_keyring", "GPG-Keyring reparieren", "sudo pacman -Sy archlinux-keyring", "Behebt Signature-Fehler bei veralteten Schlüsseln", true, listOf("gpg", "keyring")),
                    CheatItem("arch_mirrors", "Schnellste Mirrors finden", "reflector --country Germany --latest 10 --sort rate --save /etc/pacman.d/mirrorlist", "Optimiert die Download-Geschwindigkeit via Reflector", true, listOf("mirror", "reflector")),
                    CheatItem("arch_db_unlock", "Gesperrte pacman.db entfernen", "sudo rm /var/lib/pacman/db.lck", "Behebt Hänger, wenn ein Update unterbrochen wurde", true, listOf("lock", "db")),
                    CheatItem("arch_downgrade", "Paket auf Vorversion downgraden", "sudo pacman -U /var/cache/pacman/pkg/<paket-version>.pkg.tar.zst", "Installiert Vorversion direkt aus lokalem Cache", true, listOf("downgrade", "rollback"))
                )
            ),
            CheatSection(
                id = "arch_system",
                title = "Arch System & Wartung",
                items = listOf(
                    CheatItem("arch_systemctl_start", "Dienst starten", "sudo systemctl start <dienst>", "Startet einen Hintergrunddienst", true, listOf("systemd", "start")),
                    CheatItem("arch_systemctl_enable", "Dienst bei Boot aktivieren", "sudo systemctl enable --now <dienst>", "Aktiviert Autostart und startet Dienst sofort", true, listOf("systemd", "enable")),
                    CheatItem("arch_systemctl_status", "Dienst-Status prüfen", "systemctl status <dienst>", "Zeigt Logs und PID des Dienstes an", true, listOf("systemd", "status")),
                    CheatItem("arch_failed", "Fehlgeschlagene Dienste prüfen", "systemctl --failed", "Listet alle Dienste auf, die beim Boot gecrasht sind", true, listOf("systemd", "failed")),
                    CheatItem("arch_kernel_params", "Aktive Kernel-Boot-Parameter", "cat /proc/cmdline", "Zeigt Parameter des Bootloaders (Grub/Systemd-boot)", true, listOf("boot", "kernel")),
                    CheatItem("arch_mkinitcpio", "Initramfs neu generieren", "sudo mkinitcpio -P", "Erstellt Kernel-Images für alle Kernel neu", true, listOf("initramfs", "kernel")),
                    CheatItem("arch_grub_update", "GRUB Konfiguration neu schreiben", "sudo grub-mkconfig -o /boot/grub/grub.cfg", "Erkennt neu installierte Kernel und Betriebssysteme", true, listOf("grub", "boot")),
                    CheatItem("arch_genfstab", "fstab UUIDs prüfen", "cat /etc/fstab", "Dateisystem-Einhängepunkte und UUID-Mapping", true, listOf("fstab", "disk")),
                    CheatItem("arch_check_news", "Arch News vor Updates lesen", "arch-audit", "Prüft bekannte Sicherheitslücken installierter Pakete", true, listOf("security", "news")),
                    CheatItem("arch_pacdiff", "Konfigurations-Updates mergen", "sudo pacdiff", "Findet und vereint .pacnew Konfigurationsdateien", true, listOf("pacdiff", "config")),
                    CheatItem("arch_coredump", "Crashes untersuchen", "coredumpctl list", "Zeigt Stacktraces von abgestürzten Programmen", true, listOf("coredump", "debug")),
                    CheatItem("arch_clean_journal", "Systemd Journal auf 200MB kürzen", "sudo journalctl --vacuum-size=200M", "Gibt Festplattenspeicher von alten Logfiles frei", true, listOf("journal", "clean"))
                )
            )
        )
    ),

    // -------------------------------------------------------------------------
    // 3. Fedora (31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "fedora",
        title = "Fedora",
        subtitle = "DNF & Config",
        group = CategoryGroup.LINUX_DESKTOP,
        iconType = CategoryIconType.FEDORA,
        sections = listOf(
            CheatSection(
                id = "fedora_dnf",
                title = "DNF Paketmanagement",
                items = listOf(
                    CheatItem("fed_upgrade", "System aktualisieren", "sudo dnf upgrade --refresh", "Erzwingt frische Metadaten und aktualisiert Pakete", true, listOf("dnf", "update")),
                    CheatItem("fed_install", "Paket installieren", "sudo dnf install <paket>", "Installiert ein RPM-Paket", true, listOf("install", "rpm")),
                    CheatItem("fed_remove", "Paket deinstallieren", "sudo dnf remove <paket>", "Löscht Paket und ungenutzte Abhängigkeiten", true, listOf("remove", "uninstall")),
                    CheatItem("fed_search", "Software suchen", "dnf search <begriff>", "Findet passende Pakete in den aktiven Repositories", true, listOf("search", "find")),
                    CheatItem("fed_info", "Paketdetails anzeigen", "dnf info <paket>", "Zeigt Version, Release, Lizenz und Quell-Repository", true, listOf("info", "rpm")),
                    CheatItem("fed_history", "Letzte Transaktion rückgängig machen", "sudo dnf history undo last", "Rollt die vorherige DNF-Transaktion zuverlässig zurück", true, listOf("undo", "rollback")),
                    CheatItem("fed_history_list", "Transaktionshistorie anzeigen", "dnf history list", "Listet alle jemals ausgeführten Installationen und Updates", true, listOf("history", "list")),
                    CheatItem("fed_history_info", "Transaktion im Detail ansehen", "dnf history info <id>", "Zeigt welche Pakete in Transaktion N verändert wurden", true, listOf("history", "detail")),
                    CheatItem("fed_autoremove", "Ungenutzte Pakete bereinigen", "sudo dnf autoremove", "Entfernt verwaiste Bibliotheken", true, listOf("clean", "orphans")),
                    CheatItem("fed_clean", "DNF Cache leeren", "sudo dnf clean all", "Löscht heruntergeladene Metadaten und RPM-Caches", true, listOf("cache", "clean")),
                    CheatItem("fed_group_list", "Paketgruppen auflisten", "dnf group list", "Zeigt z.B. 'Development Tools' oder Desktop-Umgebungen", true, listOf("group", "desktop")),
                    CheatItem("fed_group_install", "Paketgruppe installieren", "sudo dnf groupinstall \"Development Tools\"", "Installiert alle Compiler und Tools auf einmal", true, listOf("group", "tools"))
                )
            ),
            CheatSection(
                id = "fedora_repos",
                title = "RPM Fusion & Flatpak",
                items = listOf(
                    CheatItem("fed_rpmfusion_free", "RPM Fusion Free Repo aktivieren", "sudo dnf install https://mirrors.rpmfusion.org/free/fedora/rpmfusion-free-release-$(rpm -E %fedora).noarch.rpm", "Ermöglicht Installation von Open-Source Codecs", true, listOf("rpmfusion", "codecs")),
                    CheatItem("fed_rpmfusion_nonfree", "RPM Fusion Nonfree Repo aktivieren", "sudo dnf install https://mirrors.rpmfusion.org/nonfree/fedora/rpmfusion-nonfree-release-$(rpm -E %fedora).noarch.rpm", "Für Nvidia-Treiber und proprietäre Codecs", true, listOf("rpmfusion", "nvidia")),
                    CheatItem("fed_flatpak_flathub", "Flathub Repository hinzufügen", "flatpak remote-add --if-not-exists flathub https://flathub.org/repo/flathub.flatpakrepo", "Aktiviert die globale Flatpak-Softwarequelle", true, listOf("flatpak", "flathub")),
                    CheatItem("fed_flatpak_install", "Flatpak installieren", "flatpak install flathub <app_id>", "Lädt Sandboxed-Applikation von Flathub herunter", true, listOf("flatpak", "install")),
                    CheatItem("fed_flatpak_update", "Alle Flatpaks aktualisieren", "flatpak update -y", "Aktualisiert alle installierten Flatpaks", true, listOf("flatpak", "update")),
                    CheatItem("fed_copr_enable", "COPR Community Repo aktivieren", "sudo dnf copr enable <user/project>", "Schaltet inoffizielle Community-Builds frei", true, listOf("copr", "repo")),
                    CheatItem("fed_copr_list", "Aktive COPR Repos anzeigen", "dnf copr list", "Listet aktivierte COPR Softwarequellen auf", true, listOf("copr", "list")),
                    CheatItem("fed_nvidia_driver", "Nvidia Treiber via RPM Fusion", "sudo dnf install akmod-nvidia xorg-x11-drv-nvidia-cuda", "Installiert proprietäre Nvidia Grafiktreiber", true, listOf("nvidia", "driver"))
                )
            ),
            CheatSection(
                id = "fedora_admin",
                title = "SELinux & System-Wartung",
                items = listOf(
                    CheatItem("fed_selinux_status", "SELinux Status prüfen", "sestatus", "Zeigt ob SELinux im 'enforcing' Modus läuft", true, listOf("selinux", "security")),
                    CheatItem("fed_selinux_permissive", "SELinux temporär permissiv setzen", "sudo setenforce 0", "Protokolliert Verstöße ohne Zugriffe zu blockieren", true, listOf("selinux", "debug")),
                    CheatItem("fed_selinux_audit", "SELinux Audit-Logs analysieren", "sudo ausearch -m avc -ts recent", "Findet kürzliche Berechtigungs-Verweigerungen", true, listOf("selinux", "audit")),
                    CheatItem("fed_firewall_status", "Firewalld Status prüfen", "sudo firewall-cmd --state", "Prüft ob die Fedora Standard-Firewall aktiv ist", true, listOf("firewall", "security")),
                    CheatItem("fed_firewall_port", "Port in Firewall freigeben", "sudo firewall-cmd --permanent --add-port=8080/tcp && sudo firewall-cmd --reload", "Öffnet Port dauerhaft in der Standard-Zone", true, listOf("firewall", "port")),
                    CheatItem("fed_system_release", "Fedora Versionsupgrade", "sudo dnf system-upgrade download --releasever=41", "Lädt alle Pakete für die nächste Fedora-Hauptversion herunter", true, listOf("upgrade", "release")),
                    CheatItem("fed_system_reboot", "Systemupgrade ausführen", "sudo dnf system-upgrade reboot", "Führt das Offline-OS-Upgrade beim Reboot durch", true, listOf("upgrade", "reboot")),
                    CheatItem("fed_cockpit", "Cockpit Web-Admin Konsole starten", "sudo systemctl enable --now cockpit.socket", "Weboberfläche auf Port 9090 für Server-Management", true, listOf("cockpit", "webadmin")),
                    CheatItem("fed_btrfs_scrub", "Btrfs Dateisystem prüfen", "sudo btrfs scrub start /", "Überprüft Prüfsummen auf Btrfs-Root-Dateisystem", true, listOf("btrfs", "disk")),
                    CheatItem("fed_hostname", "System-Hostnamen ändern", "hostnamectl set-hostname <neuer-name>", "Aktualisiert Gerätenamen sofort persistent", true, listOf("hostname", "network")),
                    CheatItem("fed_locale", "Systemsprache konfigurieren", "localectl set-locale LANG=de_DE.UTF-8", "Stellt Zeichensatz und Sprache auf Deutsch ein", true, listOf("locale", "lang"))
                )
            )
        )
    ),

    // -------------------------------------------------------------------------
    // 4. Linux Mint (31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "mint",
        title = "Mint",
        subtitle = "Apt & Desktop",
        group = CategoryGroup.LINUX_DESKTOP,
        iconType = CategoryIconType.MINT,
        sections = listOf(
            CheatSection(
                id = "mint_apt",
                title = "APT & Software-Management",
                items = listOf(
                    CheatItem("mint_update", "Paketlisten & System aktualisieren", "sudo apt update && sudo apt upgrade -y", "Der klassische Debian/Ubuntu Update-Zweischritt", true, listOf("apt", "upgrade")),
                    CheatItem("mint_install", "Paket installieren", "sudo apt install <paket>", "Installiert ein Softwarepaket aus den Repositories", true, listOf("install", "apt")),
                    CheatItem("mint_purge", "Paket restlos entfernen", "sudo apt purge <paket>", "Löscht das Paket inklusive aller Konfigurationsdateien", true, listOf("purge", "remove")),
                    CheatItem("mint_search", "In Repositories suchen", "apt search <begriff>", "Sucht nach Namen und Beschreibungen", true, listOf("search", "find")),
                    CheatItem("mint_show", "Paketdetails anzeigen", "apt show <paket>", "Gibt Version, Downloadgröße und Abhängigkeiten aus", true, listOf("show", "apt")),
                    CheatItem("mint_autoremove", "Ungenutzte Pakete bereinigen", "sudo apt autoremove --purge", "Löscht alte Kernel und ungenutzte Bibliotheken", true, listOf("clean", "kernel")),
                    CheatItem("mint_deb", "Manuelles .deb Paket installieren", "sudo dpkg -i paket.deb && sudo apt-get -f install", "Installiert DEB-Datei und behebt fehlende Abhängigkeiten", true, listOf("dpkg", "deb")),
                    CheatItem("mint_clean", "Paket-Download-Cache leeren", "sudo apt clean", "Gibt Festplattenspeicher im /var/cache/apt frei", true, listOf("cache", "disk")),
                    CheatItem("mint_ppa", "PPA hinzufügen", "sudo add-apt-repository ppa:<name> && sudo apt update", "Fügt ein Launchpad PPA zur Paketverwaltung hinzu", true, listOf("ppa", "repo")),
                    CheatItem("mint_ppa_remove", "PPA entfernen", "sudo add-apt-repository --remove ppa:<name>", "Löscht PPA aus den Quellen", true, listOf("ppa", "remove")),
                    CheatItem("mint_held", "Gesperrte Pakete anzeigen", "apt-mark showhold", "Listet Pakete auf, deren Updates eingefroren wurden", true, listOf("hold", "apt")),
                    CheatItem("mint_hold_pkg", "Paket-Update einfrieren", "sudo apt-mark hold <paket>", "Verhindert automatisches Aktualisieren des Pakets", true, listOf("hold", "lock"))
                )
            ),
            CheatSection(
                id = "mint_tools",
                title = "Mint Systemtools & Timeshift",
                items = listOf(
                    CheatItem("mint_timeshift", "Snapshot vor Update anlegen", "sudo timeshift --create --comments \"Vor Update\"", "Sichert das Dateisystem per Btrfs oder RSYNC ab", true, listOf("backup", "timeshift")),
                    CheatItem("mint_timeshift_list", "Vorhandene Snapshots auflisten", "sudo timeshift --list", "Zeigt alle verfügbaren Wiederherstellungspunkte", true, listOf("timeshift", "list")),
                    CheatItem("mint_timeshift_restore", "Snapshot wiederherstellen", "sudo timeshift --restore", "Startet interaktives Rollback im Terminal", true, listOf("timeshift", "restore")),
                    CheatItem("mint_drivers", "Treiber autokonfigurieren", "sudo ubuntu-drivers autoinstall", "Erkennt und installiert Grafikkarten- und WLAN-Treiber", true, listOf("driver", "hardware")),
                    CheatItem("mint_inxi", "Detaillierter Hardware-Report", "inxi -Fz", "Zeigt CPU, GPU, Audio, Partitionen und Kernel sauber formatiert", true, listOf("inxi", "hardware")),
                    CheatItem("mint_cinnamon_restart", "Cinnamon Desktop neustarten", "Strg + Alt + Esc", "Startet den Window-Manager bei Hängern sofort neu", false, listOf("cinnamon", "restart")),
                    CheatItem("mint_nemo", "Dateimanager als Root öffnen", "sudo nemo", "Öffnet Nemo mit vollen Administratorrechten", true, listOf("nemo", "root")),
                    CheatItem("mint_update_cli", "MintUpdate über Terminal", "mintupdate-cli upgrade -r", "Verwendet den offiziellen Mint Update Manager im CLI-Modus", true, listOf("mintupdate", "cli"))
                )
            ),
            CheatSection(
                id = "mint_cinnamon_keys",
                title = "Cinnamon Desktop Shortcuts",
                items = listOf(
                    CheatItem("mint_menu", "Startmenü öffnen", "Super (Windows-Taste)", "Öffnet das Cinnamon Hauptmenü", false, listOf("menu", "start")),
                    CheatItem("mint_run", "Befehl ausführen Dialog", "Alt + F2", "Schnellzugriff zum Ausführen von Befehlen", false, listOf("run", "altf2")),
                    CheatItem("mint_lock", "Bildschirm sperren", "Strg + Alt + L", "Sperrt die Arbeitsstation sofort", false, listOf("lock", "security")),
                    CheatItem("mint_terminal", "Terminal Hotkey", "Strg + Alt + T", "Startet sofort das Standard-Terminal", false, listOf("terminal", "hotkey")),
                    CheatItem("mint_scale", "Fenster-Übersicht (Expo)", "Strg + Alt + Pfeil Oben", "Zeigt alle offenen Fenster auf dem Desktop", false, listOf("expo", "overview")),
                    CheatItem("mint_desktops", "Virtuelle Desktops Übersicht", "Strg + Alt + Pfeil Unten", "Zeigt alle virtuellen Arbeitsflächen im Raster", false, listOf("desktops", "grid")),
                    CheatItem("mint_snap_left", "Fenster links anheften", "Super + Pfeil Links", "Platziert Fenster bündig links", false, listOf("snap", "tile")),
                    CheatItem("mint_snap_right", "Fenster rechts anheften", "Super + Pfeil Rechts", "Platziert Fenster bündig rechts", false, listOf("snap", "tile")),
                    CheatItem("mint_minimize_all", "Desktop anzeigen", "Super + D", "Minimiert alle Fenster auf die Taskleiste", false, listOf("desktop", "minimize")),
                    CheatItem("mint_screenshot", "Bereichs-Screenshot", "Shift + Druck", "Ermöglicht Auswahlrechteck für Bildschirmfoto", false, listOf("screenshot", "snip")),
                    CheatItem("mint_logout", "Abmeldedialog öffnen", "Strg + Alt + Entf", "Öffnet Dialog zum Abmelden, Neustarten oder Herunterfahren", false, listOf("logout", "shutdown"))
                )
            )
        )
    ),

    // -------------------------------------------------------------------------
    // 5. Hyprland (31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "hyprland",
        title = "Hyprland",
        subtitle = "Config & Tiling",
        group = CategoryGroup.LINUX_DESKTOP,
        iconType = CategoryIconType.HYPRLAND,
        sections = listOf(
            CheatSection(
                id = "hypr_keys",
                title = "Fenster- & Workspace-Tastenkürzel",
                items = listOf(
                    CheatItem("hypr_term", "Terminal öffnen", "SUPER + Q", "Startet das Standard-Terminal (kitty/alacritty)", false, listOf("terminal", "exec")),
                    CheatItem("hypr_kill", "Aktives Fenster schließen", "SUPER + C", "Schließt fokussiertes Fenster sauber", false, listOf("kill", "close")),
                    CheatItem("hypr_float", "Floating Modus umschalten", "SUPER + V", "Löst Fenster aus dem automatischen Tiling-Gitter", false, listOf("float", "tile")),
                    CheatItem("hypr_fullscreen", "Vollbild umschalten", "SUPER + F", "Schaltet echtes Vollbild für Fenster an/aus", false, listOf("fullscreen", "focus")),
                    CheatItem("hypr_fake_full", "Fake-Fullscreen", "SUPER + SHIFT + F", "Fenster füllt Tiling-Bereich ohne echte Vollbild-Flags", false, listOf("fake", "fullscreen")),
                    CheatItem("hypr_menu", "App-Launcher starten", "SUPER + R (oder SUPER + D)", "Öffnet wofi / rofi zum Starten installierter Apps", false, listOf("launcher", "wofi")),
                    CheatItem("hypr_focus_left", "Fokus nach links", "SUPER + H (oder Pfeil Links)", "Vim-Navigation nach links", false, listOf("focus", "left")),
                    CheatItem("hypr_focus_down", "Fokus nach unten", "SUPER + J (oder Pfeil Unten)", "Vim-Navigation nach unten", false, listOf("focus", "down")),
                    CheatItem("hypr_focus_up", "Fokus nach oben", "SUPER + K (oder Pfeil Oben)", "Vim-Navigation nach oben", false, listOf("focus", "up")),
                    CheatItem("hypr_focus_right", "Fokus nach rechts", "SUPER + L (oder Pfeil Rechts)", "Vim-Navigation nach rechts", false, listOf("focus", "right")),
                    CheatItem("hypr_move_win", "Fensterposition tauschen", "SUPER + SHIFT + H/J/K/L", "Tauscht Fensterposition im Tiling-Baum", false, listOf("swap", "move")),
                    CheatItem("hypr_ws_switch", "Zu Workspace 1–9 wechseln", "SUPER + [1–9]", "Wechselt sofort auf den virtuellen Arbeitsplatz", false, listOf("workspace", "virtual")),
                    CheatItem("hypr_move_ws", "Fenster auf Workspace verschieben", "SUPER + SHIFT + [1–9]", "Verschiebt aktives Fenster auf den Ziel-Arbeitsplatz", false, listOf("move", "workspace")),
                    CheatItem("hypr_move_silent", "Still auf Workspace verschieben", "SUPER + CTRL + [1–9]", "Verschiebt Fenster ohne Workspace-Fokus zu wechseln", false, listOf("silent", "workspace")),
                    CheatItem("hypr_split", "Tiling Splitrichtung toggeln", "SUPER + J", "Schaltet Split zwischen horizontal und vertikal um", false, listOf("split", "tile")),
                    CheatItem("hypr_pin", "Fenster anheften (Pin)", "SUPER + Y", "Hält Floating-Fenster auf allen Workspaces sichtbar", false, listOf("pin", "sticky"))
                )
            ),
            CheatSection(
                id = "hypr_control",
                title = "Hyprctl Steuerung & IPC",
                items = listOf(
                    CheatItem("hypr_monitors", "Monitore auflisten", "hyprctl monitors", "Zeigt Auflösung, Skalierung & Position via IPC", true, listOf("display", "screen")),
                    CheatItem("hypr_clients", "Offene Fenster anzeigen", "hyprctl clients", "Listet alle aktiven Fenster mit Klassen und Adressen", true, listOf("clients", "windows")),
                    CheatItem("hypr_workspaces", "Aktive Workspaces auflisten", "hyprctl workspaces", "Zeigt belegte Desktops und zugehörige Monitore", true, listOf("workspaces", "list")),
                    CheatItem("hypr_reload", "Konfiguration neu laden", "hyprctl reload", "Wendet hyprland.conf Änderungen sofort ohne Neustart an", true, listOf("config", "reload")),
                    CheatItem("hypr_dispatch_kill", "Befehl per IPC absenden", "hyprctl dispatch killactive", "Schließt aktives Fenster skriptgesteuert", true, listOf("ipc", "dispatch")),
                    CheatItem("hypr_dispatch_exec", "Programm über Hyprland starten", "hyprctl dispatch exec [workspace 2] alacritty", "Startet Terminal direkt auf definiertem Workspace", true, listOf("exec", "workspace")),
                    CheatItem("hypr_version", "Hyprland Version & Flags", "hyprctl version", "Zeigt Commit-Hash und aktivierte Compile-Features", true, listOf("version", "build")),
                    CheatItem("hypr_layers", "Wayland Layer-Shell Surfaces", "hyprctl layers", "Zeigt Waybar, Dunst und Wofi Oberflächen an", true, listOf("layers", "wayland"))
                )
            ),
            CheatSection(
                id = "hypr_config",
                title = "Wichtige Config-Snippets (hyprland.conf)",
                items = listOf(
                    CheatItem("hypr_cfg_monitor", "Monitor konfigurieren", "monitor=DP-1,1920x1080@144,0x0,1", "Setzt Name, Auflösung, Hz, Position und Skalierung", true, listOf("config", "monitor")),
                    CheatItem("hypr_cfg_env", "Nvidia Wayland Umgebungsvariablen", "env = LIBVA_DRIVER_NAME,nvidia\nenv = GBM_BACKEND,nvidia-drm", "Zwingt Nvidia Hardware-Beschleunigung auf Wayland", true, listOf("nvidia", "env")),
                    CheatItem("hypr_cfg_autostart", "Programme beim Start ausführen", "exec-once = waybar & hyprpaper & dunst", "Startet Statusleiste, Wallpaper & Notification Daemon", true, listOf("autostart", "exec")),
                    CheatItem("hypr_cfg_gaps", "Fensterabstände definieren", "general {\n    gaps_in = 6\n    gaps_out = 12\n}", "Stellt Innen- und Außenabstände im Tiling ein", true, listOf("gaps", "padding")),
                    CheatItem("hypr_cfg_borders", "Aktive Randfarbe mit Farbverlauf", "col.active_border = rgba(84b0aeff) rgba(527276ff) 45deg", "Erzeugt zweifarbigen Gradienten auf aktivem Fenster", true, listOf("border", "gradient")),
                    CheatItem("hypr_cfg_windowrule", "Fensterregel (z.B. immer Floating)", "windowrule = float, ^(pavucontrol)$", "Öffnet Audio-Mixer immer als schwebendes Fenster", true, listOf("windowrule", "float")),
                    CheatItem("hypr_cfg_blur", "Transparenz & Frosted Glass Blur", "decoration {\n    blur {\n        enabled = true\n        size = 8\n        passes = 2\n    }\n}", "Aktiviert GPU-Weichzeichnung hinter Fenstern", true, listOf("blur", "glass"))
                )
            )
        )
    ),

    // -------------------------------------------------------------------------
    // 6. KDE Plasma (31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "kde_plasma",
        title = "KDE Plasma",
        subtitle = "Shortcuts & KWin",
        group = CategoryGroup.LINUX_DESKTOP,
        iconType = CategoryIconType.KDE_PLASMA,
        sections = listOf(
            CheatSection(
                id = "kde_shortcuts",
                title = "KWin & Workspace Kürzel",
                items = listOf(
                    CheatItem("kde_krunner", "KRunner Schnellstart", "Alt + Leertaste (oder Meta)", "Befehlszeile, Taschenrechner, Fenstersuche & App-Starter", false, listOf("krunner", "launch")),
                    CheatItem("kde_overview", "Fenster-Übersicht (Parachute)", "Meta + W", "Zeigt alle aktiven Fenster übersichtlich nebeneinander", false, listOf("overview", "expose")),
                    CheatItem("kde_dolphin", "Dateimanager Dolphin", "Meta + E", "Öffnet das persönliche Verzeichnis in Dolphin", false, listOf("dolphin", "files")),
                    CheatItem("kde_lock", "Bildschirm sofort sperren", "Meta + L", "Sichert die Sitzung und sperrt den Bildschirm", false, listOf("lock", "sicherheit")),
                    CheatItem("kde_settings", "Systemeinstellungen öffnen", "Meta + I", "Schnellzugriff auf alle KDE-Konfigurationen", false, listOf("settings", "config")),
                    CheatItem("kde_tile_left", "Fenster links anheften", "Meta + Pfeil Links", "Platziert das Fenster auf der linken Bildschirmhälfte", false, listOf("tile", "snap")),
                    CheatItem("kde_tile_right", "Fenster rechts anheften", "Meta + Pfeil Rechts", "Platziert das Fenster auf der rechten Bildschirmhälfte", false, listOf("tile", "snap")),
                    CheatItem("kde_tile_max", "Fenster maximieren", "Meta + Pfeil Oben", "Maximiert das aktuelle Fenster", false, listOf("maximize", "window")),
                    CheatItem("kde_tile_min", "Fenster minimieren", "Meta + Pfeil Unten", "Minimiert das aktive Fenster in die Leiste", false, listOf("minimize", "window")),
                    CheatItem("kde_grid", "Raster virtueller Desktops", "Strg + F8", "Zeigt alle Desktops als interaktives Raster an", false, listOf("desktops", "grid")),
                    CheatItem("kde_switch_ws", "Zwischen Desktops wechseln", "Strg + F1 / F2 / F3 / F4", "Springt direkt auf Desktop 1 bis 4", false, listOf("workspace", "switch")),
                    CheatItem("kde_kill", "Grafischen Prozess killen", "Strg + Alt + Esc", "Verwandelt den Cursor in ein Fadenkreuz zum Klick-Abschuss", false, listOf("xkill", "freeze")),
                    CheatItem("kde_spectacle", "Screenshot Tool Spectacle", "Druck (oder Shift + Druck)", "Öffnet Spectacle für Bereichs- oder Fensterauswahl", false, listOf("screenshot", "spectacle")),
                    CheatItem("kde_clipboard", "Klipper Zwischenablageverlauf", "Meta + V", "Öffnet Historie der kopierten Elemente", false, listOf("klipper", "clipboard")),
                    CheatItem("kde_activities", "KDE Aktivitäten-Verwaltung", "Meta + Q", "Schaltet zwischen definierten Aktivitäten-Workspaces um", false, listOf("activities", "workspaces"))
                )
            ),
            CheatSection(
                id = "kde_cli",
                title = "KDE Diagnose & Shell Steuerung",
                items = listOf(
                    CheatItem("kde_restart_plasma5", "Plasma Shell neustarten (Plasma 5)", "kquitapp5 plasmashell && kstart5 plasmashell", "Startet die Desktop-Oberfläche bei Hängern neu", true, listOf("restart", "kwin")),
                    CheatItem("kde_restart_plasma6", "Plasma Shell neustarten (Plasma 6)", "systemctl --user restart plasma-plasmashell", "Moderner Systemd-User-Neustart der Oberfläche", true, listOf("systemd", "plasma6")),
                    CheatItem("kde_kwin_restart", "KWin Window Manager neustarten", "kwin_x11 --replace & (oder kwin_wayland)", "Ersetzt laufenden Fenstermanager im Fehlerfall", true, listOf("kwin", "replace")),
                    CheatItem("kde_krunner_cli", "KRunner per Terminal steuern", "qdbus org.kde.krunner /App display", "Bringt die KRunner Leiste programmatisch in den Vordergrund", true, listOf("qdbus", "krunner")),
                    CheatItem("kde_theme_cli", "Plasma Theme per Terminal wechseln", "lookandfeeltool --apply org.kde.breezedark.desktop", "Schaltet systemweites Design auf Breeze Dark um", true, listOf("theme", "lookandfeel")),
                    CheatItem("kde_list_themes", "Installierte KDE Themes anzeigen", "lookandfeeltool --list", "Listet alle verfügbaren globalen Themes auf", true, listOf("themes", "list")),
                    CheatItem("kde_shortcut_dump", "KDE Tastenkombinationen anzeigen", "kreadconfig5 --file kglobalshortcutsrc", "Liest globale Hotkeys aus der Konfiguration aus", true, listOf("config", "shortcuts")),
                    CheatItem("kde_audio_ctl", "Audio per Pipewire/Pulse steuern", "pactl set-sink-volume @DEFAULT_SINK@ +5%", "Erhöht die Lautstärke um 5 Prozent im Terminal", true, listOf("audio", "pactl"))
                )
            ),
            CheatSection(
                id = "kde_features",
                title = "Spezielle Plasma Features",
                items = listOf(
                    CheatItem("kde_kdeconnect", "KDE Connect Geräte koppeln", "kdeconnect-cli --list-available", "Findet gekoppelte Smartphones für Zwischenablage & SMS", true, listOf("kdeconnect", "phone")),
                    CheatItem("kde_kdeconnect_ring", "Smartphone über PC klingeln lassen", "kdeconnect-cli --ring -d <device_id>", "Lässt verlegtes Android-Telefon klingeln", true, listOf("kdeconnect", "ring")),
                    CheatItem("kde_vault", "KDE Vaults (Verschlüsselte Ordner)", "plasma-vault", "Verwaltet CryFS/EncFS verschlüsselte Safes", true, listOf("vault", "security")),
                    CheatItem("kde_discover", "KDE Discover Paketzentrum CLI", "pkcon refresh && pkcon update", "PackageKit CLI für Updates im Hintergrund", true, listOf("discover", "packagekit")),
                    CheatItem("kde_screen_temp", "Nachtmodus Farbtemperatur", "qdbus org.kde.KWin /ColorCorrect org.kde.kwin.ColorCorrect.setNightColor true", "Aktiviert Blaulichtfilter programmatisch", true, listOf("nightcolor", "display")),
                    CheatItem("kde_session_save", "Sitzung manuell speichern", "qdbus org.kde.ksmserver /KSMServer org.kde.KSMServerInterface.saveCurrentSession", "Sichert aktuell geöffnete Fenster für nächsten Start", true, listOf("session", "save")),
                    CheatItem("kde_compositor_toggle", "Compositor umschalten (X11)", "Shift + Alt + F12", "Schaltet Effekte für maximale Gaming-FPS an/aus", false, listOf("compositor", "gaming")),
                    CheatItem("kde_window_rules", "KWin Regeln bearbeiten", "kcmshell5 kwinrules", "Öffnet Editor für fensterspezifische Ausnahmen", true, listOf("kwinrules", "kcmshell"))
                )
            )
        )
    )
)
