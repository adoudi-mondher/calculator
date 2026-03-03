# Penser Objet (POO)
## Cours débutant – reconversion / formation professionnelle
### Fil rouge : projet *Calculatrice*

---

## Sommaire
- [Introduction – Pourquoi la POO ?](#introduction-poo)
- [Classe, objet et responsabilité](#classe-objet-responsabilite)
- [Encapsulation](#encapsulation)
- [Abstraction](#abstraction)
- [Interfaces et polymorphisme](#interfaces-polymorphisme)
- [Héritage – pourquoi on ne l’utilise pas ici](#heritage)
- [Constructeurs – quand et pourquoi](#constructeurs)
- [Getters / Setters – pourquoi on ne les utilise pas ici](#getters-setters)
- [Séparation des responsabilités (UI / Application / Métier)](#separation-responsabilites)
- [Gestion des erreurs](#gestion-erreurs)
- [UML – lecture orale (version examen)](#uml-lecture-orale)
- [Patterns utilisés (expliqués simplement)](#patterns)
- [SOLID appliqué](#solid)
- [Règles d’or à retenir](#regles-or)
- [Questions typiques du jury](#questions-jury)

---

<h2 id="introduction-poo">1. Introduction – Pourquoi la POO ?</h2>

La programmation orientée objet (POO) est une **manière de structurer un programme** pour :
- mieux raisonner,
- faciliter l’évolution,
- séparer les responsabilités.

👉 La POO n’est pas une fin en soi, mais un **outil de conception**.

🗣️ **À l’oral (jury)**
> La POO permet de structurer un logiciel autour de responsabilités claires plutôt que d’une suite d’instructions.

---

<h2 id="classe-objet-responsabilite">2. Classe, objet et responsabilité</h2>

- Une **classe** représente une intention et une responsabilité.
- Un **objet** est une instance concrète créée à l’exécution.

### Exemples (calculatrice)
- `Application` : orchestre le scénario utilisateur
- `Calculatrice` : exécute un calcul
- `Operation` : définit une règle de calcul
- `ConsoleUI` : gère l’entrée et la sortie console

👉 Une classe doit avoir **une seule raison de changer**.

🗣️ **À l’oral**
> J’ai structuré mon application autour de responsabilités uniques afin de limiter les couplages.

---

<h2 id="encapsulation">3. Encapsulation</h2>

L’encapsulation consiste à :
- cacher les détails internes,
- exposer uniquement ce qui est nécessaire.

### Exemple
`Calculatrice` :
- aucun état exposé
- une seule méthode publique `executer(...)`

🗣️ **À l’oral**
> L’encapsulation protège l’état interne des objets et limite les dépendances.

---

<h2 id="abstraction">4. Abstraction</h2>

Abstraire, c’est :
> se concentrer sur **ce que fait** une entité, pas **comment elle le fait**.

### Exemple
`Operation` abstrait la notion de calcul :
- addition
- soustraction
- division

👉 L’Application ne connaît pas les détails.

🗣️ **À l’oral**
> L’abstraction me permet de raisonner en termes de comportements plutôt qu’en termes d’implémentation.

---

<h2 id="interfaces-polymorphisme">5. Interfaces et polymorphisme</h2>

### Interface
Une interface définit un **contrat**.

Exemple :
- `Operation` impose une méthode de calcul.

### Polymorphisme
Le polymorphisme permet d’utiliser différentes implémentations via une même interface.

👉 Même appel, comportements différents.

🗣️ **À l’oral**
> Grâce au polymorphisme, la calculatrice peut exécuter toute opération respectant le contrat Operation.

---

<h2 id="heritage">6. Héritage – pourquoi on ne l’utilise pas ici</h2>

Bien que tentant, l’héritage n’est pas pertinent ici :
- pas de comportement commun à factoriser
- risque de couplage fort

👉 Une interface suffit.

🗣️ **À l’oral**
> J’ai volontairement évité l’héritage pour privilégier les interfaces et limiter le couplage.

---

<h2 id="constructeurs">7. Constructeurs – quand et pourquoi</h2>

Un constructeur sert à **garantir qu’un objet est valide dès sa création**.

### Pourquoi un constructeur dans `Application`
`Application` ne peut fonctionner sans :
- une `UserInterface`
- une `Calculatrice`

👉 Le constructeur impose ces dépendances.

### Pourquoi pas ailleurs
- `Calculatrice` est **stateless**
- `Operation` n’a pas d’état
- `ConsoleUI` gère seule son `Scanner`

🗣️ **À l’oral**
> J’utilise un constructeur uniquement lorsque des dépendances sont indispensables au bon fonctionnement de la classe.

---

<h2 id="getters-setters">8. Getters / Setters – pourquoi on ne les utilise pas ici</h2>

Les getters/setters servent à exposer ou modifier un **état**.

Dans ce projet :
- la majorité des classes sont sans état
- les attributs existants sont internes et immuables

👉 Aucun besoin réel de getters/setters.

🗣️ **À l’oral**
> Je n’ajoute pas de getters/setters par habitude, uniquement lorsqu’il y a un besoin fonctionnel réel.

---

<h2 id="separation-responsabilites">9. Séparation des responsabilités (UI / Application / Métier)</h2>

### Découpage clair
- **UI** : lire / afficher
- **Application** : décider / orchestrer
- **Métier** : calculer

### Exemple
- la boucle est dans `Application`
- le calcul est dans `Operation`
- l’affichage est dans `ConsoleUI`

🗣️ **À l’oral**
> Cette séparation permet de changer l’interface sans impacter la logique métier.

---

<h2 id="gestion-erreurs">10. Gestion des erreurs</h2>

### Deux types d’erreurs
- **Métier** → `OperationException` (division par zéro)
- **Technique / saisie** → `UserInputException`

### Principe
- on lève l’exception là où l’erreur est détectée
- on l’attrape là où une décision est possible

👉 Les boucles sont dans `Application`.

---

<h2 id="uml-lecture-orale">11. UML – lecture orale (version examen)</h2>

- Application possède une UserInterface et une Calculatrice → associations porteuses (1..1).
- ConsoleUI implémente UserInterface → relation « est une ».
- Operation est une interface ; Addition, Soustraction, Multiplication, Division l’implémentent.
- Calculatrice utilise une Operation comme paramètre → association simple (pas de possession).
- Application crée une Operation (`creerOperation`) → dépendance `<<create>>`.
- Division peut signaler une règle métier via OperationException → dépendance `<<throws>>`.

---

<h2 id="patterns">12. Patterns utilisés (expliqués simplement)</h2>

- **Strategy** : les règles de calcul sont interchangeables.
- **Orchestrateur** : Application pilote le scénario utilisateur.
- **Service stateless** : Calculatrice ne conserve aucun état.

---

<h2 id="solid">13. SOLID appliqué</h2>

- **S** : une responsabilité par classe
- **O** : ajout d’une opération sans modifier l’existant
- **L** : toute implémentation d’Operation est interchangeable
- **D** : dépendance aux abstractions, pas aux implémentations

---

<h2 id="regles-or">14. Règles d’or à retenir</h2>

- une classe = une responsabilité
- on boucle là où on décide
- on délègue là où on exécute
- pas d’héritage par réflexe
- pas de getters/setters par habitude
- une exception signale un problème, elle ne pilote pas le flux

---

<h2 id="questions-jury">15. Questions typiques du jury</h2>

**Pourquoi une classe Application ?**  
→ Pour séparer l’orchestration du point d’entrée technique (`main`).

**Pourquoi pas tout dans le main ?**  
→ Ce serait du procédural, difficile à maintenir.

**Pourquoi une interface Operation ?**  
→ Pour découpler la calculatrice des règles de calcul.

**Pourquoi peu de constructeurs ?**  
→ Parce que seules les classes avec des dépendances obligatoires en ont besoin.

**Comment passer à une GUI ?**  
→ En remplaçant ConsoleUI sans toucher au métier.

---

### Conclusion
Ce projet de calculatrice sert de support pour apprendre **à penser objet**,  
pas seulement à écrire du code.
