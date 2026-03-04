# Calculatrice -- Projet POO (Java 17)

Projet pédagogique réalisé dans le cadre de la formation Concepteur
Développeur d'Applications.

Objectif : concevoir une application console en appliquant les principes
de la programmation orientée objet (POO), les bases d'architecture
logicielle et plusieurs patterns de conception.

------------------------------------------------------------------------

## Technologies

-   Java 17
-   Maven (pom.xml)
-   JUnit 4.13.2
-   API `java.time` (timestamp historique)

------------------------------------------------------------------------

## Architecture

Le projet est structuré en couches distinctes :

ui → gestion des entrées/sorties utilisateur
app → orchestration du scénario applicatif
metier → logique métier (calculs)
persistence → sauvegarde des opérations (DAO)

### Diagramme UML

Voir le fichier : diagrammeClasses.png

------------------------------------------------------------------------

## Principes de conception

### Séparation des responsabilités

-   `ConsoleUI` : lecture et affichage console
-   `Application` : gestion de la boucle et coordination
-   `Calculatrice` : exécution des calculs
-   `Operation` : abstraction d'une règle de calcul
-   `HistoriqueDAO` : abstraction de la persistance

------------------------------------------------------------------------

## Patterns utilisés

### Strategy

Les différentes opérations (`Addition`, `Soustraction`,
`Multiplication`, `Division`) implémentent l'interface `Operation`.
La calculatrice exécute une opération sans connaître son implémentation
concrète.

### Factory

`OperationFactory` centralise la création des opérations.

### DAO (Data Access Object)

`HistoriqueDAO` abstrait la sauvegarde des opérations.
`CsvHistoriqueDAO` implémente un stockage fichier CSV.

### Injection de dépendances

Les dépendances sont injectées via les constructeurs (`Application`).

------------------------------------------------------------------------

## Gestion des erreurs

Deux types d'exceptions sont distingués :

-   `UserInputException` → erreur de saisie utilisateur
-   `OperationException` → erreur métier (ex : division par zéro)

Les exceptions sont interceptées dans `Application`, qui décide de
l'affichage et de la persistance.

------------------------------------------------------------------------

## Persistance

Chaque opération est enregistrée dans un fichier `historique.csv`.

Format :

date;a;symbole;b;resultat;statut;message

Exemples :

2026-03-03 15:42:10;2;+;3;5.00;SUCCESS;
2026-03-03 15:43:02;5;/;0;;ERROR;Division par zéro

Caractéristiques :

-   Timestamp généré via `java.time`
-   Sauvegarde des succès et des erreurs
-   Architecture extensible (remplacement possible par base de données
    sans modifier le métier)

------------------------------------------------------------------------

## Tests

Tests unitaires réalisés avec JUnit 4.13.2 :

-   validation du parsing
-   validation des cas d'erreur
-   validation des opérations

------------------------------------------------------------------------

## Lancement

### Via un IDE

1.  Importer le projet comme projet Maven
2.  Exécuter la classe `Main`

### En ligne de commande (si Maven installé)

mvn clean compile
mvn exec:java

------------------------------------------------------------------------

## Principes SOLID appliqués

-   **S** : une responsabilité par classe
-   **O** : ajout d'une nouvelle opération ou d'un nouveau mode de
    persistance sans modifier l'existant
-   **L** : toute implémentation de `Operation` est interchangeable
-   **D** : dépendance aux abstractions (`Operation`, `HistoriqueDAO`)

------------------------------------------------------------------------

## Évolutions possibles

-   Remplacement du CSV par une base de données
-   Ajout d'une interface graphique (GUI)
-   Extension des opérations
-   Amélioration de la couverture de tests
-   Ajout d'un système de lecture d'historique

------------------------------------------------------------------------

## Conclusion

Ce projet met en œuvre une architecture simple mais structurée,
démontrant :

-   une compréhension des principes POO
-   une séparation claire des responsabilités
-   l'application de patterns classiques
-   une conception évolutive et maintenable

---

## Contributeurs
**Implication égale**

- **Mondher Adoudi**
- **Vincent HAUVUY**
- **Jeremy GAY**

---
