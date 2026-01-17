# Penser Objet (POO) – Cours débutant / reconversion
### Fil rouge : projet *Calculatrice*

---

## Sommaire

1. [Introduction – Pourquoi la POO](#1-introduction--pourquoi-la-poo)
2. [Classe, objet et responsabilité](#2-classe-objet-et-responsabilité)
3. [Encapsulation](#3-encapsulation)
4. [Abstraction](#4-abstraction)
5. [Interfaces et polymorphisme](#5-interfaces-et-polymorphisme)
6. [Héritage – pourquoi on ne l’utilise pas ici](#6-héritage--pourquoi-on-ne-lutilise-pas-ici)
7. [Constructeurs – quand et pourquoi](#7-constructeurs--quand-et-pourquoi)
8. [Getters / Setters – pourquoi on ne les utilise pas ici](#8-getters--setters--pourquoi-on-ne-les-utilise-pas-ici)
9. [Séparation des responsabilités](#9-séparation-des-responsabilités)
10. [Gestion des erreurs](#10-gestion-des-erreurs)
11. [UML – lecture orale (version examen)](#11-uml--lecture-orale-version-examen)
12. [Patterns utilisés](#12-patterns-utilisés)
13. [SOLID appliqué](#13-solid-appliqué)
14. [Règles d’or à retenir](#14-règles-dor-à-retenir)
15. [Questions typiques du jury](#15-questions-typiques-du-jury)


---

## 1️⃣ Introduction – Pourquoi la POO ?

La programmation orientée objet est une **manière de structurer un programme** pour :
- mieux raisonner,
- faciliter l’évolution,
- séparer les responsabilités.

👉 La POO n’est pas une fin en soi, mais un **outil de conception**.

🗣️ *À l’oral*
> La POO permet de structurer un logiciel autour de responsabilités claires plutôt que d’une suite d’instructions.

---

## 2️⃣ Classe, objet et responsabilité

Une **classe** représente une **intention** et une **responsabilité**.  
Un **objet** est une instance concrète de cette classe à l’exécution.

Exemples :
- `Application` → orchestre le scénario
- `Calculatrice` → exécute un calcul
- `Operation` → définit une règle de calcul
- `ConsoleUI` → gère les entrées/sorties

👉 Une classe = **une raison de changer**.

---

## 3️⃣ Encapsulation

L’encapsulation consiste à :
- cacher les détails internes,
- exposer uniquement ce qui est nécessaire.

Exemple :
- `Calculatrice` n’expose qu’une méthode `executer(...)`
- elle ne révèle aucun état interne

🗣️ *À l’oral*
> L’encapsulation limite les dépendances et protège l’intégrité des objets.

---

## 4️⃣ Abstraction

Abstraire, c’est :
> se concentrer sur **ce que fait** une entité, pas **comment elle le fait**.

Exemple :
- `Operation` abstrait le concept de calcul
- l’Application ignore s’il s’agit d’une addition ou d’une division

---

## 5️⃣ Interfaces et polymorphisme

### Interface
Une interface définit un **contrat**.

Exemple :
- `Operation` impose une méthode de calcul

### Polymorphisme
Le polymorphisme permet d’utiliser différentes implémentations via une même interface.

👉 Même appel, comportements différents.

🗣️ *À l’oral*
> Le polymorphisme permet d’ajouter de nouvelles opérations sans modifier la calculatrice.

---

## 6️⃣ Héritage – Pourquoi on ne l’utilise pas ici

Bien que tentant, l’héritage n’apporte rien dans ce projet :
- pas de comportement commun à factoriser
- risque de couplage fort

👉 Une interface suffit.

🗣️ *À l’oral*
> J’ai privilégié les interfaces à l’héritage pour favoriser la flexibilité et limiter le couplage.

---

## 7️⃣ Constructeurs – Quand et pourquoi

Un constructeur sert à **garantir qu’un objet est valide dès sa création**.

### Pourquoi on en utilise un dans `Application`
- `Application` **ne peut pas fonctionner sans** :
  - une `UserInterface`
  - une `Calculatrice`

👉 Le constructeur impose ces dépendances.

### Pourquoi on n’en utilise pas ailleurs
- `Calculatrice` est **stateless**
- `Operation` n’a pas d’état
- `ConsoleUI` initialise seule son `Scanner`

🗣️ *À l’oral*
> J’utilise un constructeur uniquement lorsque des dépendances sont indispensables au bon fonctionnement de la classe.

---

## 8️⃣ Getters / Setters – Pourquoi on ne les utilise pas ici

Les getters/setters servent à **exposer ou modifier un état**.

Dans ce projet :
- la majorité des classes sont **sans état**
- les attributs existants sont **internes et immuables**

👉 Aucun besoin réel de getters/setters.

🗣️ *À l’oral*
> Je n’ai pas ajouté de getters/setters par habitude, uniquement en cas de besoin réel.

---

## 9️⃣ Séparation des responsabilités

### Découpage clair
- **UI** : lire / afficher
- **Application** : décider / orchestrer
- **Métier** : calculer

### Exemple
- la boucle est dans `Application`
- le calcul est dans `Operation`
- l’affichage est dans `ConsoleUI`

🗣️ *À l’oral*
> La séparation des responsabilités permet de faire évoluer une couche sans impacter les autres.

---

## 🔟 Gestion des erreurs

Deux types d’erreurs :
- **Métier** → `OperationException` (division par zéro)
- **Technique / saisie** → `UserInputException`

Principe :
- on lève l’exception là où l’erreur est détectée
- on l’attrape là où une décision est possible

---

## 1️⃣1️⃣ UML – Lecture orale (version examen)

Application possède une UserInterface et une Calculatrice → associations porteuses (1..1).  
ConsoleUI implémente UserInterface → relation *est une*.  
Operation est une interface ; Addition, Soustraction, Multiplication, Division l’implémentent.  
Calculatrice utilise une Operation comme paramètre → association simple.  
Application crée une Operation → dépendance `<<create>>`.  
Division peut lever OperationException → dépendance `<<throws>>`.

---

## 1️⃣2️⃣ Patterns utilisés (expliqués simplement)

- **Strategy** : les opérations sont interchangeables
- **Orchestrateur** : Application pilote le scénario
- **Service stateless** : Calculatrice ne conserve aucun état

---

## 1️⃣3️⃣ SOLID appliqué

- **S** : une responsabilité par classe
- **O** : ajout d’une opération sans modifier l’existant
- **L** : toute implémentation d’Operation est interchangeable
- **D** : dépendance aux abstractions, pas aux implémentations

---

## 1️⃣4️⃣ Règles d’or à retenir

- une classe = une responsabilité
- on boucle là où on décide
- on délègue là où on exécute
- pas d’héritage par réflexe
- pas de getters/setters par habitude
- une exception signale un problème, elle ne pilote pas le flux

---

## 1️⃣5️⃣ Questions typiques du jury

**Pourquoi une classe Application ?**  
→ Pour séparer l’orchestration du point d’entrée technique.

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
