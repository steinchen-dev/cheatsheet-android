package com.example.data.repository

import com.example.data.model.CategoryGroup
import com.example.data.model.CategoryIconType
import com.example.data.model.CheatCategory
import com.example.data.model.CheatItem
import com.example.data.model.CheatSection

/**
 * 30+ praxisnahe Shortcuts & Befehle für Bash/Terminal, Netzwerk & SSH und Docker.
 */
val devOpsCategories: List<CheatCategory> = listOf(
    // -------------------------------------------------------------------------
    // 1. Bash / Terminal (31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "bash",
        title = "Bash",
        subtitle = "Pipes & Scripting",
        group = CategoryGroup.DEVOPS_SYS,
        iconType = CategoryIconType.BASH,
        sections = listOf(
            CheatSection(
                id = "bash_scripting",
                title = "Robuste Scripting Standards",
                items = listOf(
                    CheatItem("bash_strict", "Strict Mode Header", "#!/usr/bin/env bash\nset -euo pipefail", "Bricht bei Fehlern, ungesetzten Variablen & Pipe-Fehlern sofort ab", true, listOf("safety", "pipefail")),
                    CheatItem("bash_redirection", "Stdout & Stderr umleiten", "command > output.log 2>&1", "Leitet sowohl normale Ausgabe als auch Fehlermeldungen in eine Datei", true, listOf("redirect", "logs")),
                    CheatItem("bash_awk", "Spalten extrahieren mit AWK", "ps aux | awk '{print $1, $2, $11}'", "Gibt User, PID und Prozessname formatiert aus", true, listOf("awk", "columns")),
                    CheatItem("bash_sed", "Suchen und Ersetzen in Dateien", "sed -i 's/alt/neu/g' datei.txt", "Ersetzt alle Vorkommnisse direkt in der Datei", true, listOf("sed", "replace")),
                    CheatItem("bash_xargs", "Parallele Befehlsausführung", "find . -name \"*.log\" | xargs -I {} rm -f {}", "Führt Operationen zeilenweise auf Input-Listen aus", true, listOf("xargs", "batch")),
                    CheatItem("bash_trap", "Cleanup bei Skript-Exit (Trap)", "trap 'rm -f \"\$TEMP_FILE\"' EXIT INT TERM", "Löscht temporäre Dateien zuverlässig bei Skriptende", true, listOf("trap", "cleanup")),
                    CheatItem("bash_heredoc", "Here-Doc Konfiguration schreiben", "cat << 'EOF' > /tmp/config.env\nPORT=8080\nENV=prod\nEOF", "Erzeugt strukturierte Konfigurationsdateien im Skript", true, listOf("heredoc", "file")),
                    CheatItem("bash_default_val", "Standardwert für Parameter", "NAME=\"\${1:-Gast}\"", "Setzt Fallback-Wert falls Argument nicht übergeben wurde", true, listOf("param", "default")),
                    CheatItem("bash_array_iter", "Array sicher iterieren", "for item in \"\${my_array[@]}\"; do\n    echo \"Item: \$item\"\ndone", "Behandelt Leerzeichen und Sonderzeichen robust", true, listOf("array", "loop")),
                    CheatItem("bash_check_cmd", "Prüfen ob Befehl installiert ist", "if command -v docker &>/dev/null; then\n    echo \"Vorhanden\"\nfi", "Prüft Abhängigkeiten vor der Skriptausführung", true, listOf("command", "check")),
                    CheatItem("bash_wait", "Hintergrundjobs synchronisieren", "wait -n", "Wartet bis mindestens ein Hintergrundprozess beendet ist", true, listOf("wait", "jobs"))
                )
            ),
            CheatSection(
                id = "bash_text_proc",
                title = "Textverarbeitung & Filterung",
                items = listOf(
                    CheatItem("bash_sort_uniq", "Duplikate zählen und sortieren", "cat access.log | sort | uniq -c | sort -nr", "Zeigt häufigste Log-Einträge absteigend sortiert an", true, listOf("sort", "uniq")),
                    CheatItem("bash_cut", "Spalten per Trennzeichen schneiden", "cut -d':' -f1,3 /etc/passwd", "Extrahiert Benutzername und UID aus passwd-Datei", true, listOf("cut", "passwd")),
                    CheatItem("bash_wc", "Zeilen zählen", "wc -l datei.txt", "Gibt die genaue Zeilenanzahl einer Datei aus", true, listOf("wc", "lines")),
                    CheatItem("bash_grep_invert", "Zeilen ausschließen (Invert Grep)", "grep -v \"^#\" config.conf | grep -v \"^$\"", "Filtert Kommentare und Leerzeilen aus Konfigurationen", true, listOf("grep", "filter")),
                    CheatItem("bash_tr", "Zeichen ersetzen / Großschreibung", "cat text.txt | tr '[:lower:]' '[:upper:]'", "Konvertiert gesamten Stream in Großbuchstaben", true, listOf("tr", "case")),
                    CheatItem("bash_tee", "Ausgabe auf Bildschirm & Datei", "make build 2>&1 | tee build.log", "Zeigt Compiler-Ausgabe an und sichert sie parallel in Log", true, listOf("tee", "log")),
                    CheatItem("bash_head_tail", "Bestimmte Zeilen anzeigen (z.B. 10–20)", "sed -n '10,20p' datei.txt", "Gibt Zeilen 10 bis 20 ohne Laden der gesamten Datei aus", true, listOf("sed", "lines")),
                    CheatItem("bash_jq", "JSON im Terminal formatieren", "cat response.json | jq '.data[0].id'", "Filtert und formatiert JSON strukturiert mit Farben", true, listOf("jq", "json")),
                    CheatItem("bash_base64", "String Base64 kodieren/dekodieren", "echo -n \"secret\" | base64\necho \"c2VjcmV0\" | base64 -d", "Schnelle Base64 Transformation auf der CLI", true, listOf("base64", "encode")),
                    CheatItem("bash_sha256", "Prüfsumme einer Datei ermitteln", "sha256sum datei.iso", "Berechnet kryptografischen SHA-256 Hash", true, listOf("sha256", "hash"))
                )
            ),
            CheatSection(
                id = "bash_tricks",
                title = "Interaktive CLI-Tricks & History",
                items = listOf(
                    CheatItem("bash_sudo_bang", "Letzten Befehl mit sudo ausführen", "sudo !!", "Führt den vorherigen Befehl mit Root-Rechten aus", true, listOf("sudo", "history")),
                    CheatItem("bash_last_arg", "Letztes Argument wiederverwenden", "mkdir -p /pfad && cd \$_", "Springt mit \$_ direkt in das soeben erstellte Verzeichnis", true, listOf("history", "args")),
                    CheatItem("bash_brace_expand", "Backup einer Datei anlegen", "cp config.yml{,.bak}", "Expandiert zu: cp config.yml config.yml.bak", true, listOf("brace", "backup")),
                    CheatItem("bash_disown", "Prozess von Shell abkoppeln", "nohup ./server > server.log 2>&1 & disown", "Lässt Prozess auch nach Schließen des Terminals weiterlaufen", true, listOf("nohup", "disown")),
                    CheatItem("bash_quick_http", "Lokalen HTTP-Server starten", "python3 -m http.server 8000", "Stellt aktuellen Ordner sofort im lokalen Netzwerk bereit", true, listOf("http", "python")),
                    CheatItem("bash_watch", "Befehl alle 2 Sekunden ausführen", "watch -n 2 'df -h'", "Wiederholt Befehl zyklisch und hebt Änderungen hervor", true, listOf("watch", "monitor")),
                    CheatItem("bash_history_date", "Zeitstempel in History aktivieren", "export HISTTIMEFORMAT=\"%d/%m/%y %T \"", "Zeigt in 'history' genau wann ein Befehl getippt wurde", true, listOf("history", "time")),
                    CheatItem("bash_empty_file", "Große Datei schnell leeren", "> datei.log", "Setzt Dateigröße auf 0 Bytes ohne Datei zu löschen", true, listOf("truncate", "clean")),
                    CheatItem("bash_random", "Zufalls-Passwort generieren", "openssl rand -base64 16", "Erzeugt sicheres 16-Zeichen Zufallspasswort", true, listOf("password", "openssl")),
                    CheatItem("bash_alias", "Dauerhafter Alias", "alias ll='ls -lha --color=auto'", "Definiert Kurzform in ~/.bashrc", true, listOf("alias", "bashrc"))
                )
            )
        )
    ),

    // -------------------------------------------------------------------------
    // 2. Netzwerk & SSH (31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "network_ssh",
        title = "Netzwerk",
        subtitle = "SSH & Diagnose",
        group = CategoryGroup.DEVOPS_SYS,
        iconType = CategoryIconType.NETWORK_SSH,
        sections = listOf(
            CheatSection(
                id = "ssh_keys_tunnel",
                title = "SSH Konfiguration, Keys & Tunneling",
                items = listOf(
                    CheatItem("ssh_copy", "SSH-Schlüssel übertragen", "ssh-copy-id -i ~/.ssh/id_ed25519.pub user@server", "Ermöglicht passwortlose Anmeldung über Public-Key", true, listOf("key", "auth")),
                    CheatItem("ssh_local_tunnel", "Lokaler Portweiterleitung (Tunnel)", "ssh -L 8080:localhost:3000 user@server", "Macht entfernten Server-Port 3000 auf lokalem Port 8080 erreichbar", true, listOf("tunnel", "port")),
                    CheatItem("ssh_remote_tunnel", "Remote Reverse-Tunnel", "ssh -R 9000:localhost:80 user@server", "Leitet Zugriffe vom Server an den lokalen Port 80 weiter", true, listOf("reverse", "tunnel")),
                    CheatItem("ssh_socks", "Dynamischer SOCKS5 Proxy", "ssh -D 1080 -q -C -N user@server", "Routet gesamten Browser-Traffic verschlüsselt über den Server", true, listOf("socks", "proxy")),
                    CheatItem("ssh_keygen", "Modernen SSH-Key generieren", "ssh-keygen -t ed25519 -C \"admin@domain.com\"", "Erstellt sicheren, kompakten ED25519 Schlüssel", true, listOf("keygen", "ed25519")),
                    CheatItem("ssh_config_host", "SSH Config Profil (~/.ssh/config)", "Host myserver\n    HostName 192.168.1.50\n    User admin\n    IdentityFile ~/.ssh/id_ed25519", "Ermöglicht einfaches Tippen von 'ssh myserver'", true, listOf("config", "host")),
                    CheatItem("ssh_agent", "Schlüssel im SSH-Agent cachen", "eval $(ssh-agent) && ssh-add ~/.ssh/id_ed25519", "Verhindert wiederholte Passphrase-Eingaben", true, listOf("agent", "key")),
                    CheatItem("ssh_jump", "Über Jump-Host (Bastion) verbinden", "ssh -J jumpuser@bastion.com targetuser@intern.server", "Tunnelt SSH-Verbindung sicher über Zwischenstation", true, listOf("jump", "bastion")),
                    CheatItem("ssh_escape", "Hängende SSH-Sitzung beenden", "Enter ~ .", "Tastatur-Escape-Kombination zum Killen toter SSH-Clients", false, listOf("escape", "kill")),
                    CheatItem("ssh_execute", "Remote-Befehl ausführen ohne Login", "ssh user@server 'df -h && uptime'", "Gibt Ausgabe direkt auf der lokalen Konsole aus", true, listOf("exec", "remote")),
                    CheatItem("ssh_fingerprint", "Schlüssel-Fingerabdruck prüfen", "ssh-keygen -lf ~/.ssh/id_ed25519.pub", "Zeigt SHA256 Fingerprint zur Verifikation an", true, listOf("fingerprint", "security"))
                )
            ),
            CheatSection(
                id = "net_diagnosis",
                title = "Sockets, Traffic & Diagnose",
                items = listOf(
                    CheatItem("net_ss", "Offene Ports & Sockets anzeigen", "ss -tulpn", "Listet alle lauschenden TCP/UDP Ports samt Prozess-PID", true, listOf("ports", "listen")),
                    CheatItem("net_ip", "Kompakte IP-Übersicht", "ip -br a", "Zeigt Status und IP-Adressen aller Netzwerkkarten", true, listOf("ip", "interface")),
                    CheatItem("net_ip_route", "Routing-Tabelle & Gateway", "ip route show", "Zeigt Default-Gateway und Routing-Metriken", true, listOf("route", "gateway")),
                    CheatItem("net_curl", "HTTP Response Header & Timing", "curl -Iv https://example.com", "Zeigt SSL-Handshake, Redirects und Header im Detail", true, listOf("curl", "http")),
                    CheatItem("net_curl_post", "HTTP POST Request mit JSON", "curl -X POST https://api.com/items -H 'Content-Type: application/json' -d '{\"name\":\"test\"}'", "Sendet JSON-Payload an REST-Endpunkt", true, listOf("curl", "post")),
                    CheatItem("net_tcpdump", "Traffic live mitschneiden", "sudo tcpdump -i any -nn port 80 or port 443", "Protokolliert Pakete auf HTTP/HTTPS Ports in Echtzeit", true, listOf("tcpdump", "sniff")),
                    CheatItem("net_mtr", "Kombinierter Ping & Traceroute", "mtr -rwz 1.1.1.1", "Diagnostiziert Paketverlust und Latenzen entlang der Route", true, listOf("mtr", "ping")),
                    CheatItem("net_nc", "Port-Verbindungstest (Netcat)", "nc -zv 192.168.1.1 22", "Testet ob Ziel-Port erreichbar ist (Portscanner-Funktion)", true, listOf("nc", "netcat")),
                    CheatItem("net_dig", "DNS-Records abfragen (Dig)", "dig +short example.com A", "Liefert reine IP-Adresse ohne DNS-Banner zurück", true, listOf("dns", "dig")),
                    CheatItem("net_nslookup", "Nameserver prüfen", "nslookup example.com 8.8.8.8", "Fragt gezielt Google DNS nach Domain-Records ab", true, listOf("dns", "nslookup"))
                )
            ),
            CheatSection(
                id = "net_admin",
                title = "Firewall, Bandbreite & ARP",
                items = listOf(
                    CheatItem("net_speedtest", "Internet-Bandbreite messen", "speedtest-cli --simple", "Misst Ping, Download und Upload über die Konsole", true, listOf("speedtest", "bandbreite")),
                    CheatItem("net_iftop", "Bandbreiten-Verbrauch pro IP", "sudo iftop -i eth0", "Zeigt in Echtzeit welche Verbindung wie viel MB/s zieht", true, listOf("iftop", "traffic")),
                    CheatItem("net_nmap", "Subnetz nach aktiven Hosts scannen", "nmap -sn 192.168.1.0/24", "Findet alle aktiven Geräte im lokalen Netzwerk", true, listOf("nmap", "scan")),
                    CheatItem("net_arp", "ARP-Cache anzeigen (MAC-Adressen)", "ip neigh show", "Zeigt Zuordnung von IP- zu physischen MAC-Adressen", true, listOf("arp", "mac")),
                    CheatItem("net_ethtool", "Netzwerkkarte Link & Duplex Speed", "sudo ethtool eth0", "Prüft ob Kabel auf 1000Mbit/s Full-Duplex verbunden ist", true, listOf("ethtool", "hardware")),
                    CheatItem("net_ufw_status", "UFW Firewall Status", "sudo ufw status verbose", "Listet alle aktiven Firewall-Regeln auf Ubuntu/Debian", true, listOf("ufw", "firewall")),
                    CheatItem("net_ufw_allow", "Port in UFW erlauben", "sudo ufw allow 22/tcp comment 'SSH Zugang'", "Gibt Port 22 für eingehenden Traffic frei", true, listOf("ufw", "allow")),
                    CheatItem("net_whois", "Domain Inhaber & Registrar ermitteln", "whois example.com", "Zeigt Nameserver, Registrar und Ablaufdatum an", true, listOf("whois", "domain")),
                    CheatItem("net_public_ip", "Eigene öffentliche IP ermitteln", "curl -s ifconfig.me", "Gibt externe Internet-IP des Anschlusses aus", true, listOf("ip", "public")),
                    CheatItem("net_renew_dhcp", "DHCP Lease erneuern", "sudo dhclient -r && sudo dhclient", "Fordert neue IP-Adresse vom Router an", true, listOf("dhcp", "network"))
                )
            )
        )
    ),

    // -------------------------------------------------------------------------
    // 3. Docker (31 Einträge)
    // -------------------------------------------------------------------------
    CheatCategory(
        id = "docker",
        title = "Docker",
        subtitle = "Container & Compose",
        group = CategoryGroup.DEVOPS_SYS,
        iconType = CategoryIconType.DOCKER,
        sections = listOf(
            CheatSection(
                id = "doc_lifecycle",
                title = "Container Lifecycle & Steuerung",
                items = listOf(
                    CheatItem("doc_run_daemon", "Container im Hintergrund starten", "docker run -d --name mein_server -p 8080:80 nginx:alpine", "Startet Nginx im Hintergrund mit Portfreigabe", true, listOf("run", "daemon")),
                    CheatItem("doc_exec_bash", "Shell im Container öffnen", "docker exec -it <container_id> /bin/bash", "Interaktives Terminal im laufenden Container öffnen", true, listOf("exec", "shell")),
                    CheatItem("doc_exec_sh", "Alpine Shell (sh) öffnen", "docker exec -it <container_id> /bin/sh", "Für Minimal-Images ohne Bash", true, listOf("exec", "alpine")),
                    CheatItem("doc_logs_tail", "Live Logs mit Zeitstempeln", "docker logs -f --tail 100 -t <container>", "Verfolgt die letzten 100 Zeilen in Echtzeit", true, listOf("logs", "debug")),
                    CheatItem("doc_ps_format", "Formatierte Container-Tabelle", "docker ps -a --format \"table {{.Names}}\\t{{.Status}}\\t{{.Ports}}\"", "Übersichtliche Anzeige ohne Zeilenumbruch-Chaos", true, listOf("ps", "status")),
                    CheatItem("doc_stop", "Container sanft stoppen", "docker stop -t 10 <container>", "Sendet SIGTERM mit 10s Timeout vor SIGKILL", true, listOf("stop", "sigterm")),
                    CheatItem("doc_restart", "Container neustarten", "docker restart <container>", "Startet einen Container neu", true, listOf("restart", "container")),
                    CheatItem("doc_rm_force", "Laufenden Container löschen", "docker rm -f <container>", "Beendet und löscht Container in einem Schritt", true, listOf("rm", "delete")),
                    CheatItem("doc_run_tmp", "Temporären Container testen", "docker run --rm -it alpine sh", "Löscht den Container nach dem Verlassen sofort", true, listOf("run", "temporary")),
                    CheatItem("doc_stats", "Live Ressourcenverbrauch", "docker stats --no-stream", "Zeigt CPU-, RAM- und Netzwerk-Auslastung pro Container", true, listOf("stats", "ram")),
                    CheatItem("doc_top", "Laufende Prozesse im Container", "docker top <container>", "Listet Host-PIDs der Container-Prozesse auf", true, listOf("top", "process"))
                )
            ),
            CheatSection(
                id = "doc_images_build",
                title = "Images & Dockerfile",
                items = listOf(
                    CheatItem("doc_build_tag", "Image bauen mit Tag", "docker build -t myapp:1.0.0 .", "Baut das Dockerfile im aktuellen Ordner mit Tag", true, listOf("build", "tag")),
                    CheatItem("doc_build_nocache", "Image ohne Cache bauen", "docker build --no-cache -t myapp:fresh .", "Erzwingt Neu-Download aller Abhängigkeiten", true, listOf("build", "nocache")),
                    CheatItem("doc_images_list", "Lokale Images anzeigen", "docker images", "Listet alle gecachten Docker-Images mit Größe auf", true, listOf("images", "list")),
                    CheatItem("doc_rmi", "Image löschen", "docker rmi <image_id>", "Löscht ungenutztes Image aus dem lokalen Speicher", true, listOf("rmi", "delete")),
                    CheatItem("doc_history", "Dockerfile Layer-Historie", "docker history <image_name>", "Zeigt Größe und Befehle jedes einzelnen Layers", true, listOf("history", "layers")),
                    CheatItem("doc_inspect_ip", "Container IP ermitteln", "docker inspect --format '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' <container>", "Liest die interne IP im Docker-Bridge-Netz aus", true, listOf("inspect", "ip")),
                    CheatItem("doc_cp", "Datei aus Container kopieren", "docker cp <container>:/app/data.json ./data.json", "Kopiert Dateien zwischen Container und Hostsystem", true, listOf("cp", "copy")),
                    CheatItem("doc_diff", "Veränderte Dateien im Container", "docker diff <container>", "Zeigt welche Dateisystem-Dateien geändert wurden", true, listOf("diff", "filesystem")),
                    CheatItem("doc_commit", "Container als Image sichern", "docker commit <container> mein_image:backup", "Erstellt Snapshot des Containers als neues Image", true, listOf("commit", "image")),
                    CheatItem("doc_tag_push", "Image für Registry taggen", "docker tag myapp:latest registry.domain.com/myapp:latest && docker push registry.domain.com/myapp:latest", "Pusht eigenes Image in private Registry", true, listOf("push", "registry"))
                )
            ),
            CheatSection(
                id = "doc_compose_volumes",
                title = "Docker Compose & Volume-Management",
                items = listOf(
                    CheatItem("doc_compose_up", "Compose im Hintergrund starten", "docker compose up -d --build", "Baut geänderte Images und startet alle Services", true, listOf("compose", "start")),
                    CheatItem("doc_compose_down", "Compose stoppen", "docker compose down", "Stoppt Container und löscht das Compose-Netzwerk", true, listOf("compose", "stop")),
                    CheatItem("doc_compose_down_v", "Compose inklusive Volumes löschen", "docker compose down -v", "Löscht Container UND persistente anonyme Volumes", true, listOf("compose", "volumes")),
                    CheatItem("doc_compose_logs", "Logs eines bestimmten Compose-Services", "docker compose logs -f <service_name>", "Filtert Logs nur auf die angegebene Datenbank/App", true, listOf("compose", "logs")),
                    CheatItem("doc_compose_ps", "Status der Compose Services", "docker compose ps", "Zeigt Status aller Container des aktuellen Projekts", true, listOf("compose", "status")),
                    CheatItem("doc_volume_ls", "Alle Volumes auflisten", "docker volume ls", "Listet alle persistenten Docker-Datenspeicher auf", true, listOf("volume", "list")),
                    CheatItem("doc_volume_inspect", "Mount-Pfad des Volumes anzeigen", "docker volume inspect <volume_name>", "Zeigt Pfad im Hostsystem unter /var/lib/docker/volumes", true, listOf("volume", "path")),
                    CheatItem("doc_network_ls", "Docker Netzwerke anzeigen", "docker network ls", "Listet Bridge-, Host- und Overlay-Netzwerke", true, listOf("network", "list")),
                    CheatItem("doc_prune_all", "System radikal aufräumen", "docker system prune -a --volumes -f", "Löscht alle toten Container, ungenutzten Images & Volumes", true, listOf("prune", "clean")),
                    CheatItem("doc_events", "Docker Daemon Events in Echtzeit", "docker events --filter 'event=die'", "Zeigt Live-Stream aller abgestürzten Container", true, listOf("events", "daemon"))
                )
            )
        )
    )
)
