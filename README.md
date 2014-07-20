MorraCinese
===========

Un piccolo gioco basato sulle regole della Morra Cinese (Rock , Paper , Scissors)

Il progetto fornisce una piattaforma generica per lo sviluppo di giochi del tipo "morra cinese".

Nella realizzazione ho cercato di rendere la piattaforma flessibile separando gli elementi che possono cambiare.
In particolare ho pensato di permettere di modificare le regole del gioco, per consentire di riutilizzare facilmente la piattaforma per realizzare varianti del gioco come spock-lizard o anche altri giochi simili, tipo "pari o dispari" o semplici giochi di carte tipo "la carta più alta vince", e le strategie di gioco dei giocatori automatici o le modalità di presentazione del gioco agli utenti.

Per realizzare questi disaccoppiamenti ho utilizzato lo strategy-pattern per cui al gioco è associata una GameStrategy in cui sono definite le "regole" del gioco e ai giocatori è associata una PlayerStrategy che definisce come quel giocatore deve giocare (quindi la strategia di gioco per i giocatori automatici o la modalità di interazione con l'utente per gli useragents)

Tra Player e Game c'è una interazione simile ad un pattern Observer-Observable in cui i players sono osservatori del gioco e vengono notificati per eseguire delle funzioni di callback durante lo svolgimento della partita (che si "svolge" nel metodo play di Game)

Nel package platform sono quindi definite le classi Game e Player (e la classe Element che rappresenta un "elemento" giocabile i.e. CARTA, FORBICI e PIETRA per la versione classica della morra cinese) e le interfacce GameStrategy e PlayerStrategy che sono poi implementate da classi concrete che realizzano alcuni esempi di queste strategie (oltre alla definizione di alcune eccezioni).

Nel package players ci sono alcune implementazioni di PlayerStrategy: alcune politiche di gioco di giocatori automatici (una basata su semplici scelte casuali, un'altra che implementa una rudimentale politica di "intelligenza artificiale" per cercare di prevedere la prossima mossa dell'avversario), e alcune implementazioni di useragent (una Command-Line-Interface e una semplice GUI basata su Swing).
Qui il sistema è aperto per l'inserimento di altre "strategie" quali meccanismi più sofisticati di strategie di gioco o altre forme di useragents come, ad esempio, una interfaccia per Android o un agente "client/server" che possa interagire con utenti collegati in remoto.

Nel package games ho inserito due giochi (implementazioni di GameStrategy): la versione standard della morra cinese (Rock , Paper , Scissors) e la versione "Spock-Lizard" che aggiunge due elementi e fornisce regole più elaborate per i "combattimenti".
Qui il sistema è aperto per l'inserimento di nuovi giochi (sempre basati sullo stesso concetto di base della morra cinese) quali le svariate versioni con sempre più elementi e regole sempre più sofisticate o altri giochi simili come il "pari o dispari" o semplicissimi giochi di carte per bambini.

Per ogni gioco ho inserito alcuni semplicissimi programmi di test che configurano il sistema e avviano la partita. Per l'analisi del codice può essere comodo partire da questi programmini per vedere come si imposta ed avvia il sistema per poi verificare i dettagli nei sorgenti dei moduli coinvolti.

classic/MorraCineseCLI: partita a morra cinese standard (vince il primo che arriva a 5) tra computer (che sceglie le mosse casualmente con RandomPlayerStrategy) e utente (che interagisce attraverso una Command Line Interface - CLIUserAdapter)

classic/MorraCineseGUI: partita a morra cinese standard (vince il primo che arriva a 5) tra computer (che sceglie le mosse casualmente con RandomPlayerStrategy) e utente (che interagisce attraverso una GUI Swing - GUIUserAdapter)

classic/MorraCineseAgainstAI: partita a morra cinese standard (vince il primo che arriva a 5) tra computer (che sceglie le mosse con un rudimentale meccanismo di "intelligenza artificiale" - AIPlayerStrategy) e utente (che interagisce attraverso una GUI Swing - GUIUserAdapter)

spocklizard/MorraCineseSpockLizardCLI: partita a morra cinese "spock-lizard" (vince il primo che arriva a 5) tra computer (che sceglie le mosse casualmente con RandomPlayerStrategy) e utente (che interagisce attraverso una Command Line Interface - CLIUserAdapter)

spocklizard/MorraCineseSpockLizard: partita a morra cinese "spock-lizard"(vince il primo che arriva a 5) tra computer (che sceglie le mosse casualmente con RandomPlayerStrategy) e utente (che interagisce attraverso una GUI Swing - GUIUserAdapter)


Per i test unitari ho utilizzato JUnit3.
