package com.example.data.repository

import com.example.data.model.CategoryGroup
import com.example.data.model.CategoryIconType
import com.example.data.model.CheatCategory
import com.example.data.model.CheatItem
import com.example.data.model.CheatSection

/**
 * 105+ handverlesene Tools für Windows, Linux & moderne CLI/Terminal-Umgebungen.
 */
val toolsCategories: List<CheatCategory> = listOf(
    CheatCategory(
        id = "power_tools",
        title = "Power-Tools",
        subtitle = "Win, Linux & CLI Tools",
        group = CategoryGroup.KNOWLEDGE_TOOLS,
        iconType = CategoryIconType.TOOLS,
        sections = listOf(
            // -----------------------------------------------------------------
            // Sektion 1: Moderne CLI & Terminal Tools (30 Tools)
            // -----------------------------------------------------------------
            CheatSection(
                id = "tools_modern_cli",
                title = "Moderne CLI- & TUI-Tools (Blazing Fast)",
                items = listOf(
                    CheatItem("tool_rg", "ripgrep (rg)", "cargo install ripgrep (oder: sudo pacman -S ripgrep)", "Ultraflexible, blitzschnelle rekursive Volltextsuche, ignoriert .gitignore automatisch", true, listOf("grep", "search", "cli")),
                    CheatItem("tool_fzf", "fzf (Fuzzy Finder)", "git clone --depth 1 https://github.com/junegunn/fzf.git ~/.fzf && ~/.fzf/install", "Interaktiver Fuzzy-Finder für Dateien, Befehlshistorie, Git-Commits und Prozesse", true, listOf("fzf", "fuzzy", "find")),
                    CheatItem("tool_bat", "bat (Cat mit Syntax-Highlighting)", "cargo install bat (oder: sudo apt install bat)", "Moderner cat-Klon mit Syntax-Highlighting, Git-Gutter-Integration und Paging", true, listOf("cat", "syntax", "view")),
                    CheatItem("tool_eza", "eza (Moderner ls-Ersatz)", "cargo install eza (oder: sudo pacman -S eza)", "Farbiger ls-Ersatz mit Icons, Dateirechten, Git-Status und Baumansicht", true, listOf("ls", "files", "eza")),
                    CheatItem("tool_zoxide", "zoxide (Smarter cd-Befehl)", "cargo install zoxide --locked (in .bashrc: eval \"$(zoxide init bash)\")", "Lernt häufig genutzte Verzeichnisse; Sprung mit 'z ordnername' von überall aus", true, listOf("cd", "navigation", "zoxide")),
                    CheatItem("tool_btop", "btop (Ressourcenmonitor)", "sudo pacman -S btop (oder: sudo apt install btop)", "Wunderschöner TUI-Ressourcenmonitor für CPU, RAM, Datenträger, Netzwerk und Prozesse", true, listOf("top", "monitor", "system")),
                    CheatItem("tool_tldr", "tldr (Praktische Handbücher)", "npm install -g tldr (oder: sudo apt install tldr)", "Vereinfachte Community-Manpages mit direkten, praxisnahen Anwendungsbeispielen", true, listOf("man", "help", "docs")),
                    CheatItem("tool_lazygit", "lazygit (Terminal Git UI)", "go install github.com/jesseduffield/lazygit@latest", "Geniale Terminal-Benutzeroberfläche für Git: Stagen, Committen, Branching und Rebase", true, listOf("git", "tui", "ui")),
                    CheatItem("tool_jq", "jq (JSON Prozessor)", "sudo apt install jq (oder: brew install jq)", "Standardwerkzeug zum Parsen, Filtern, Transformieren und Pretty-Printen von JSON", true, listOf("json", "filter", "cli")),
                    CheatItem("tool_yq", "yq (YAML Prozessor)", "wget https://github.com/mikefarah/yq/releases/latest/download/yq_linux_amd64 -O /usr/local/bin/yq", "Das jq-Äquivalent für YAML-, XML- und CSV-Dateien", true, listOf("yaml", "xml", "config")),
                    CheatItem("tool_dust", "dust (du-Ersatz mit Balken)", "cargo install du-dust", "Grafischer Festplattenbelegungs-Analyzer direkt im Terminal mit ASCII-Balken", true, listOf("du", "disk", "storage")),
                    CheatItem("tool_hyperfine", "hyperfine (Benchmark Tool)", "cargo install hyperfine", "Präzises CLI-Benchmarking-Tool mit statistischer Analyse und Warmup-Läufen", true, listOf("benchmark", "performance")),
                    CheatItem("tool_tokei", "tokei (Code-Zeilen Zähler)", "cargo install tokei", "Zählt Millionen Zeilen Code nach Sprache sortiert in Millisekunden", true, listOf("code", "lines", "stats")),
                    CheatItem("tool_duf", "duf (Festplatten-Übersicht)", "sudo pacman -S duf (oder: go install github.com/muesli/duf@latest)", "Übersichtliche, farbige Tabelle aller eingehängten Laufwerke und Dateisysteme", true, listOf("df", "disk", "duf")),
                    CheatItem("tool_glow", "glow (Markdown Viewer)", "sudo apt install glow (oder: brew install glow)", "Rendert Markdown-Dateien mit Farben und Tabellen formatiert im Terminal", true, listOf("markdown", "view")),
                    CheatItem("tool_curlie", "curlie (Curl trifft HTTPie)", "brew install curlie (oder: go install github.com/rs/curlie@latest)", "Kombiniert die Geschwindigkeit von curl mit der Benutzerfreundlichkeit von httpie", true, listOf("curl", "http", "api")),
                    CheatItem("tool_httpie", "HTTPie", "pip install httpie (oder: sudo apt install httpie)", "Menschlich lesbarer HTTP-Client mit automatischer JSON-Formatierung und Farben", true, listOf("http", "api", "rest")),
                    CheatItem("tool_nvim", "Neovim (nvim)", "sudo pacman -S neovim (oder: brew install neovim)", "Hyperextensibler, moderner Vim-Fork mit Lua-Scripting und nativem LSP-Client", true, listOf("editor", "vim", "code")),
                    CheatItem("tool_tmux", "tmux (Terminal Multiplexer)", "sudo apt install tmux", "Teilt Terminalfenster in Panes, hält Sitzungen bei SSH-Abbrüchen aktiv", true, listOf("tmux", "terminal", "session")),
                    CheatItem("tool_zellij", "Zellij (Rust Terminal Workspace)", "cargo install --locked zellij", "Moderner Terminal-Multiplexer mit intuitivem Tab-System, Layouts und Plugin-System", true, listOf("zellij", "terminal", "rust")),
                    CheatItem("tool_yazi", "yazi (TUI File Manager)", "cargo install --locked yazi-fm yazi-cli", "Extrem schneller Terminal-Dateimanager in Rust mit Bildvorschau und Async-I/O", true, listOf("files", "manager", "tui")),
                    CheatItem("tool_mcfly", "McFly (Smarte History-Suche)", "cargo install mcfly", "Ersetzt Strg+R durch neuronale Suche basierend auf Kontext und Verzeichnis", true, listOf("history", "shell", "search")),
                    CheatItem("tool_starship", "Starship Prompt", "curl -sS https://starship.rs/install.sh | sh", "Universeller, ultraschneller Shell-Prompt für Bash, Zsh und Fish", true, listOf("prompt", "shell", "theme")),
                    CheatItem("tool_fastfetch", "fastfetch (Systeminfo-Banner)", "sudo pacman -S fastfetch (oder: sudo apt install fastfetch)", "Blitzschnelle Alternative zu neofetch in C geschrieben", true, listOf("info", "neofetch")),
                    CheatItem("tool_delta", "git-delta", "cargo install git-delta", "Wunderschöne Side-by-Side Diffs für Git mit Syntax-Highlighting im Terminal", true, listOf("git", "diff")),
                    CheatItem("tool_procs", "procs (Modernes ps)", "cargo install procs", "Farbiger Ersatz für ps mit Pager-Unterstützung und Prozessbaum", true, listOf("ps", "process")),
                    CheatItem("tool_bottom", "bottom (btm)", "cargo install bottom --locked", "Konfigurierbarer Terminal-Systemmonitor mit Live-Graphen", true, listOf("monitor", "system")),
                    CheatItem("tool_glances", "Glances (Systemmonitor)", "pip install glances", "Systemmonitor mit integriertem Web-Server und REST-API", true, listOf("monitor", "web")),
                    CheatItem("tool_croc", "croc (Ende-zu-Ende Dateitransfer)", "curl https://getcroc.schollz.com | bash", "Überträgt Dateien sicher verschlüsselt zwischen zwei beliebigen Rechnern per Codephrase", true, listOf("transfer", "p2p", "file")),
                    CheatItem("tool_entr", "entr (Run on File Change)", "sudo apt install entr", "Führt Befehle oder Tests automatisch aus, sobald überwachte Dateien gespeichert werden", true, listOf("watch", "autorun"))
                )
            ),

            // -----------------------------------------------------------------
            // Sektion 2: Windows Power-Tools & Utilities (25 Tools)
            // -----------------------------------------------------------------
            CheatSection(
                id = "tools_windows",
                title = "Windows Power-Tools & Desktop-Utilities",
                items = listOf(
                    CheatItem("tool_powertoys", "Microsoft PowerToys", "winget install Microsoft.PowerToys", "Essenzielle Tools: FancyZones, ColorPicker, Image Resizer, PowerToys Run (Alt+Space)", true, listOf("windows", "powertoys")),
                    CheatItem("tool_everything", "Everything Search (Voidtools)", "winget install voidtools.Everything", "Durchsucht Millionen von Dateien auf NTFS-Laufwerken in Echtzeit ohne Verzögerung", true, listOf("search", "files", "windows")),
                    CheatItem("tool_procexp", "Process Explorer (Sysinternals)", "winget install Microsoft.Sysinternals.ProcessExplorer", "Der ultimative Task-Manager von Mark Russinovich mit Handle- und DLL-Inspektor", true, listOf("sysinternals", "process")),
                    CheatItem("tool_procmon", "Process Monitor (Sysinternals)", "winget install Microsoft.Sysinternals.ProcessMonitor", "Protokolliert Dateisystem-, Registry- und Netzwerkaktivität jedes Prozesses live", true, listOf("sysinternals", "debug")),
                    CheatItem("tool_autohotkey", "AutoHotkey v2", "winget install AutoHotkey.AutoHotkey", "Mächtige Skriptsprache zur Automatisierung von Tastenkombinationen und Fenstern", true, listOf("automation", "hotkeys")),
                    CheatItem("tool_sharex", "ShareX", "winget install ShareX.ShareX", "Kostenloses Open-Source-Tool für Bildschirmfotos, GIFs, OCR und Auto-Upload", true, listOf("screenshot", "ocr", "gif")),
                    CheatItem("tool_notepadpp", "Notepad++", "winget install Notepad++.Notepad++", "Leichtgewichtiger, extrem stabiler Quelltext-Editor mit Regex-Suchen in Ordnern", true, listOf("editor", "text")),
                    CheatItem("tool_wiztree", "WizTree", "winget install AntibodySoftware.WizTree", "Scannt die Festplattenbelegung per MFT in Sekundenbruchteilen (viel schneller als WinDirStat)", true, listOf("disk", "storage", "clean")),
                    CheatItem("tool_rufus", "Rufus", "winget install Rufus.Rufus", "Erstellt bootfähige USB-Sticks aus ISOs mit Optionen zur Umgehung von TPM/SecureBoot", true, listOf("usb", "boot", "iso")),
                    CheatItem("tool_ventoy", "Ventoy", "winget install Ventoy.Ventoy", "Einmal auf USB installieren, danach ISOs einfach per Drag&Drop auf den Stick kopieren", true, listOf("usb", "multiboot")),
                    CheatItem("tool_crystaldisk", "CrystalDiskInfo", "winget install CrystalDewWorld.CrystalDiskInfo", "Liest S.M.A.R.T.-Gesundheitswerte, Temperatur und Betriebsstunden von SSDs/HDDs aus", true, listOf("smart", "ssd", "hardware")),
                    CheatItem("tool_7zip", "7-Zip", "winget install 7zip.7zip", "Bester Open-Source-Packer mit höchster Kompressionsrate und AES-256 Verschlüsselung", true, listOf("zip", "archive")),
                    CheatItem("tool_scoop", "Scoop Package Manager", "Set-ExecutionPolicy RemoteSigned -Scope CurrentUser; iwr -useb get.scoop.op | iex", "Kommandozeilen-Paketmanager für Windows, installiert Programme portabel ins Home-Verzeichnis", true, listOf("package", "cli", "windows")),
                    CheatItem("tool_chocolatey", "Chocolatey (choco)", "Set-ExecutionPolicy Bypass -Scope Process -Force; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))", "Der klassische Windows-Paketmanager für Systemadministratoren", true, listOf("choco", "package")),
                    CheatItem("tool_unigetui", "UniGetUI (WingetUI)", "winget install SomePythonThings.WingetUIStore", "Grafische Oberfläche für Winget, Scoop und Chocolatey mit automatischen Updates", true, listOf("gui", "winget", "updates")),
                    CheatItem("tool_winterminal", "Windows Terminal", "winget install Microsoft.WindowsTerminal", "Moderner Terminal-Emulator mit Tabs, GPU-Rendering und Profilen für PowerShell, CMD und WSL", true, listOf("terminal", "powershell")),
                    CheatItem("tool_bleachbit", "BleachBit", "winget install BleachBit.BleachBit", "Open-Source-Alternative zu CCleaner, bereinigt Caches und gibt Speicher sicher frei", true, listOf("clean", "privacy")),
                    CheatItem("tool_bulkrename", "Bulk Rename Utility", "winget install TGRMNSoftware.BulkRenameUtility", "Mächtiges Tool zum massenhaften Umbenennen von Dateien mit Regex und Zeitstempeln", true, listOf("rename", "files")),
                    CheatItem("tool_keepassxc", "KeePassXC", "winget install KeePassXCTeam.KeePassXC", "Sicherer, offline gespeicherter Open-Source Passwort-Manager ohne Cloud-Zwang", true, listOf("password", "security")),
                    CheatItem("tool_quicklook", "QuickLook", "winget install PaddyXu.QuickLook", "Bringt die macOS-Leertasten-Vorschau für PDFs, Bilder und Archive nach Windows", true, listOf("preview", "macos")),
                    CheatItem("tool_screentogif", "ScreenToGif", "winget install NickeManarin.ScreenToGif", "Nimmt Bildschirmbereiche auf und schneidet sie im integrierten Editor als schlankes GIF", true, listOf("gif", "screen")),
                    CheatItem("tool_treesize", "TreeSize Free", "winget install JAMSoftware.TreeSize.Free", "Klassische Baumstruktur zur Erkennung großer Speicherfresser", true, listOf("storage", "disk")),
                    CheatItem("tool_hwmonitor", "HWMonitor", "winget install CPUID.HWMonitor", "Überwacht Spannungen, Lüfterdrehzahlen und Temperaturen von CPU und GPU", true, listOf("hardware", "temperature")),
                    CheatItem("tool_snappy", "Snappy Driver Installer Origin", "winget install GlennDelahoy.SnappyDriverInstallerOrigin", "Installiert fehlende Windows-Treiber ohne Malware oder Werbung", true, listOf("drivers", "hardware")),
                    CheatItem("tool_dismplus", "Dism++", "winget install Chuyu-Team.Dism++", "Grafische Oberfläche für DISM zur Systembereinigung und Windows-Optimierung", true, listOf("dism", "system"))
                )
            ),

            // -----------------------------------------------------------------
            // Sektion 3: Linux SysAdmin, Netzwerk & Server Tools (25 Tools)
            // -----------------------------------------------------------------
            CheatSection(
                id = "tools_linux_sysadmin",
                title = "Linux SysAdmin, Netzwerk & Monitoring",
                items = listOf(
                    CheatItem("tool_nmap", "Nmap (Netzwerkscanner)", "sudo apt install nmap (oder: sudo pacman -S nmap)", "Scannt offene Ports, erkennt Betriebssysteme und identifiziert laufende Dienste", true, listOf("network", "security", "scan")),
                    CheatItem("tool_masscan", "masscan (Gigabit Portscanner)", "sudo apt install masscan", "Scannt Subnetze in Minuten dank asynchronem Raw-Socket-Stack", true, listOf("scan", "fast", "ports")),
                    CheatItem("tool_tcpdump", "tcpdump", "sudo apt install tcpdump", "Der Standard-Kommandozeilen-Paketschnüffler für Netzwerkverkehr", true, listOf("pcap", "network", "sniff")),
                    CheatItem("tool_wireshark", "Wireshark / TShark", "sudo apt install tshark (oder: wireshark)", "Tiefgehende Protokollanalyse aller bekannten Netzwerkprotokolle mit Dekodierung", true, listOf("wireshark", "pcap", "network")),
                    CheatItem("tool_iperf3", "iperf3 (Bandbreitentest)", "sudo apt install iperf3", "Misst den maximalen Netzwerkdurchsatz zwischen zwei Rechnern über TCP/UDP", true, listOf("speed", "bandwidth", "test")),
                    CheatItem("tool_mtr", "mtr (Enhanced Traceroute)", "sudo apt install mtr", "Kombiniert Ping und Traceroute mit kontinuierlicher Latenz- und Paketverlust-Statistik", true, listOf("ping", "traceroute")),
                    CheatItem("tool_netcat", "netcat (nc)", "sudo apt install netcat-openbsd", "Das Schweizer Taschenmesser für TCP/UDP Sockets, Portchecks und Banner-Grabbing", true, listOf("socket", "tcp", "udp")),
                    CheatItem("tool_socat", "socat (Multipurpose Relay)", "sudo apt install socat", "Verbindet Sockets, Ports, serielle Schnittstellen und SSL-Streams bidirektional", true, listOf("socket", "tunnel")),
                    CheatItem("tool_iotop", "iotop (Disk I/O Monitor)", "sudo apt install iotop", "Zeigt in Echtzeit welche Prozesse die Festplatte mit Schreib-/Lesezugriffen blockieren", true, listOf("io", "disk", "monitor")),
                    CheatItem("tool_iftop", "iftop (Netzwerk-Bandbreitenmonitor)", "sudo apt install iftop", "Zeigt den aktuellen Datenverkehr sortiert nach IP-Adresspaaren live an", true, listOf("network", "bandwidth")),
                    CheatItem("tool_nethogs", "nethogs (Bandbreite pro Prozess)", "sudo apt install nethogs", "Gruppiert den Netzwerkverkehr nach Prozess-Namen und PID statt nach Protokoll", true, listOf("network", "process")),
                    CheatItem("tool_smartctl", "smartmontools (smartctl)", "sudo apt install smartmontools", "Führt Selbsttests auf Festplatten aus und warnt vor drohendem Hardware-Ausfall", true, listOf("smart", "hdd", "ssd")),
                    CheatItem("tool_strace", "strace (System Call Tracer)", "sudo apt install strace", "Protokolliert jeden Systemaufruf eines Prozesses zur Fehlerdiagnose bei Abstürzen", true, listOf("debug", "syscall")),
                    CheatItem("tool_lsof", "lsof (List Open Files)", "sudo apt install lsof", "Listet alle geöffneten Dateien, Sockets und Netzwerkverbindungen auf", true, listOf("files", "ports")),
                    CheatItem("tool_tcpflow", "tcpflow", "sudo apt install tcpflow", "Rekonstruiert TCP-Datenströme und speichert sie als lesbare Dateien ab", true, listOf("tcp", "traffic")),
                    CheatItem("tool_wireguard", "WireGuard (wg / wg-quick)", "sudo apt install wireguard", "Moderner, extrem schneller und im Linux-Kernel integrierter VPN-Tunnel", true, listOf("vpn", "security")),
                    CheatItem("tool_fail2ban", "fail2ban", "sudo apt install fail2ban", "Sperrt IP-Adressen in der Firewall automatisch nach zu vielen Fehlversuchen (z.B. SSH)", true, listOf("security", "firewall")),
                    CheatItem("tool_ufw", "UFW (Uncomplicated Firewall)", "sudo apt install ufw", "Einfache Kommandozeilen-Firewall zur Port-Freigabe auf Debian und Ubuntu", true, listOf("firewall", "security")),
                    CheatItem("tool_nftables", "nftables (Moderner iptables-Ersatz)", "sudo apt install nftables", "Paketklassifizierung und Firewall-Regeln im modernen Linux-Kernel", true, listOf("firewall", "kernel")),
                    CheatItem("tool_certbot", "Certbot (Let's Encrypt)", "sudo apt install certbot python3-certbot-nginx", "Erstellt und erneuert kostenlose SSL/TLS-Zertifikate vollautomatisch", true, listOf("ssl", "certs", "https")),
                    CheatItem("tool_ansible", "Ansible", "pip install ansible", "Agentenlose IT-Automatisierung und Konfigurationsmanagement über SSH", true, listOf("devops", "automation")),
                    CheatItem("tool_terraform", "Terraform / OpenTofu", "brew install opentofu (oder: terraform)", "Infrastructure as Code (IaC) zur deklarativen Bereitstellung von Cloud-Ressourcen", true, listOf("iac", "cloud")),
                    CheatItem("tool_k9s", "k9s (Kubernetes TUI)", "brew install k9s (oder: pacman -S k9s)", "Interaktives Terminal-Dashboard zur Verwaltung von Kubernetes-Clustern und Pods", true, listOf("k8s", "kubernetes")),
                    CheatItem("tool_helm", "Helm (Kubernetes Paketmanager)", "curl https://raw.githubusercontent.com/helm/helm/main/scripts/get-helm-3 | bash", "Paketmanager für Kubernetes zur einfachen Bereitstellung komplexer Stacks", true, listOf("k8s", "helm")),
                    CheatItem("tool_stern", "stern (Multi-Pod Log Tailer)", "brew install stern", "Streamt Logs mehrerer Kubernetes-Pods und Container farbig und simultan", true, listOf("k8s", "logs"))
                )
            ),

            // -----------------------------------------------------------------
            // Sektion 4: Dev, Container, API & Security Tools (25 Tools)
            // -----------------------------------------------------------------
            CheatSection(
                id = "tools_dev_security",
                title = "Dev, Container, API & Security Tools",
                items = listOf(
                    CheatItem("tool_podman", "Podman", "sudo apt install podman", "Rootless, daemon-loser Docker-Ersatz mit identischer Befehlssyntax", true, listOf("docker", "podman")),
                    CheatItem("tool_distrobox", "Distrobox", "curl -s https://raw.githubusercontent.com/89luca89/distrobox/main/install | sudo sh", "Startet jede Linux-Distribution nahtlos im Terminal mit Zugriff auf Home-Verzeichnis", true, listOf("container", "distrobox")),
                    CheatItem("tool_lazydocker", "lazydocker", "curl https://raw.githubusercontent.com/jesseduffield/lazydocker/master/scripts/install_update.sh | bash", "Terminal-UI zum Verwalten von Docker Containern, Images und Volumes mit Tastenkürzeln", true, listOf("docker", "tui")),
                    CheatItem("tool_ctop", "ctop", "sudo wget https://github.com/bcicen/ctop/releases/download/v0.7.7/ctop-0.7.7-linux-amd64 -O /usr/local/bin/ctop && sudo chmod +x /usr/local/bin/ctop", "Top-ähnliche Übersicht für Container-Ressourcen in Echtzeit", true, listOf("docker", "monitor")),
                    CheatItem("tool_dive", "dive (Docker Image Explorer)", "brew install dive (oder: pacman -S dive)", "Analysiert Docker-Images Layer für Layer und deckt verschwendeten Speicherplatz auf", true, listOf("docker", "image", "clean")),
                    CheatItem("tool_hadolint", "hadolint (Dockerfile Linter)", "brew install hadolint", "Prüft Dockerfiles gegen Best Practices und ShellCheck-Regeln", true, listOf("docker", "linter")),
                    CheatItem("tool_bruno", "Bruno (Postman Alternative)", "winget install Usebruno.Bruno (oder: brew install bruno)", "Schneller, leichtgewichtiger API-Client; speichert Collections lokal als Textdateien im Git", true, listOf("api", "rest", "postman")),
                    CheatItem("tool_dbeaver", "DBeaver Community", "winget install dbeaver.dbeaver", "Universelles Multi-Plattform Datenbank-Management-Tool für Postgres, MySQL, SQLite uvm.", true, listOf("database", "sql", "gui")),
                    CheatItem("tool_insomnia", "Insomnia", "winget install Insomnia.Insomnia", "Eleganter REST-, GraphQL- und gRPC-Client für Entwickler", true, listOf("api", "graphql")),
                    CheatItem("tool_mkcert", "mkcert", "brew install mkcert (oder: choco install mkcert)", "Erstellt lokal vertrauenswürdige HTTPS-Entwicklungszertifikate ohne Browserwarnungen", true, listOf("ssl", "certs", "dev")),
                    CheatItem("tool_ngrok", "ngrok", "winget install Inconshreveable.Ngrok", "Macht lokalen Webserver (z.B. localhost:3000) über öffentliche URL erreichbar", true, listOf("tunnel", "webhook")),
                    CheatItem("tool_mitmproxy", "mitmproxy", "pip install mitmproxy", "Interaktiver HTTPS-Proxy zum Analysieren und Manipulieren von mobilem und Web-Traffic", true, listOf("proxy", "debug", "traffic")),
                    CheatItem("tool_act", "act (GitHub Actions lokal ausführen)", "brew install act", "Führt GitHub Actions Workflows lokal in Docker aus für schnelles Debuggen", true, listOf("github", "actions", "ci")),
                    CheatItem("tool_shellcheck", "ShellCheck", "sudo apt install shellcheck", "Statisches Analysetool für Shell-Skripte, findet Bugs und Sicherheitslücken", true, listOf("bash", "lint", "safety")),
                    CheatItem("tool_sqlmap", "sqlmap", "pip install sqlmap", "Automatisches Tool zum Erkennen und Ausnutzen von SQL-Injection-Schwachstellen", true, listOf("security", "sql", "pentest")),
                    CheatItem("tool_k6", "k6 (Moderne Lasttests)", "brew install k6 (oder: sudo apt install k6)", "Entwicklerfreundliches Lasttest-Tool mit Testszenarien in JavaScript", true, listOf("loadtest", "performance")),
                    CheatItem("tool_wrk", "wrk (HTTP Benchmarking)", "sudo apt install wrk", "Erzeugt mit Multithreading Millionen HTTP-Anfragen zur Performance-Messung", true, listOf("benchmark", "http")),
                    CheatItem("tool_valgrind", "Valgrind", "sudo apt install valgrind", "Speicher-Debugger für C/C++, erkennt Memory Leaks und ungültige Pointer-Zugriffe", true, listOf("memory", "c", "debug")),
                    CheatItem("tool_gdb", "GDB (GNU Debugger)", "sudo apt install gdb", "Standard-Debugger zur schrittweisen Programmausführung und Core-Dump-Analyse", true, listOf("gdb", "debug")),
                    CheatItem("tool_prettier", "Prettier", "npm install -g prettier", "Meinungsstarker Code-Formatter für JS, TS, HTML, CSS, JSON und Markdown", true, listOf("format", "code")),
                    CheatItem("tool_eslint", "ESLint", "npm install -g eslint", "Pluggbarer Linter für JavaScript und TypeScript zur Einhaltung von Standards", true, listOf("lint", "javascript")),
                    CheatItem("tool_biome", "Biome (Ultra-Fast Toolchain)", "npm install -g @biomejs/biome", "Extrem schneller Linter und Formatter in Rust (Ersatz für Prettier + ESLint)", true, listOf("biome", "rust", "lint")),
                    CheatItem("tool_sops", "sops (Secrets Operations)", "brew install sops", "Verschlüsselt sensible Werte in YAML/JSON-Dateien mit PGP, AWS KMS oder GCP KMS", true, listOf("secrets", "security")),
                    CheatItem("tool_age", "age (Verschlüsselungstool)", "sudo apt install age (oder: brew install age)", "Einfaches, sicheres Verschlüsselungstool mit kleinen Schlüsseln (moderne GPG-Alternative)", true, listOf("crypto", "encryption")),
                    CheatItem("tool_vault", "HashiCorp Vault", "brew install vault", "Zentrales Secrets-Management für API-Keys, Passwörter und dynamische Datenbank-Zertifikate", true, listOf("vault", "secrets", "security"))
                )
            )
        )
    )
)
