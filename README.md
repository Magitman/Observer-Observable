# Observer-Observable

Sia data l'applicazione Exercise1, che è composta da:
un contatore (Counter) che genera 50 numeri in ordine crescente e, per ogni multiplo m di 5, invoca un filtro passandogli m;
un filtro (Filter) che, per ogni numero che riceve, aggiunge il numero a una lista di valori e, se la lista ha lunghezza pari, invoca un visualizzatore per visualizzarla su output;
un visualizzatore (Visualizer) che visualizza su output la lista di numeri che riceve in input.
Si riscriva il codice dell'applicazione per organizzare la pipeline di lavoro utilizzando il pattern Observer-Observable.

Sviluppare l'applicazione ProverbsApp utilizzando il pattern MVC, che offre un bottone per richiedere un proverbio estratto in modo random da una lista di proverbi.
Nello specifico:
la View dell'applicazione include solo un bottone per richiedere un proverbio e una label per visualizzare il testo del proverbio (nella figura, "proverbio1");
il Model dell'applicazione memorizza una lista di proverbi e, su richiesta, sceglie casualmente il proverbio da restituire;
il Controller intercetta gli eventi della view: quando l'utente preme il bottone della view, il controller invoca il model per attivare l'identificazione (internamente al model) del nuovo proverbio attuale, da visualizzare.
HELP: quando il controller intercetta un evento della view, dovrebbe invocare un metodo del model che fa scegliere l'indice del prossimo proverbio da restituire. A quel punto il model cambia stato e attiva i suoi observers con setChanged() e notifyObservers(), facendo sì che la view si aggiorni in automatico per visualizzare il proverbio "attuale".
