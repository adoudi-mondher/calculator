# Penser Objet (POO)

## Support personnel -- Référence de conception

### Fil rouge : projet Calculatrice

------------------------------------------------------------------------

## 1. Pourquoi la POO ?

La programmation orientée objet est une manière de structurer un
logiciel autour de responsabilités claires plutôt qu'une suite
d'instructions procédurales.

Objectifs : - raisonner par entités cohérentes - limiter le couplage -
faciliter l'évolution - améliorer la maintenabilité

------------------------------------------------------------------------

## 2. Classe, objet et responsabilité

-   Une classe représente une responsabilité.
-   Un objet est une instance concrète créée à l'exécution.

Dans le projet Calculatrice :

-   `Application` → orchestre le scénario
-   `Calculatrice` → exécute un calcul
-   `Operation` → définit une règle de calcul
-   `ConsoleUI` → gère l'entrée / sortie
-   `HistoriqueDAO` → gère la persistance

Règle clé : \> Une classe doit avoir une seule raison de changer.

------------------------------------------------------------------------

## 3. Encapsulation

L'encapsulation consiste à : - cacher l'implémentation interne - exposer
uniquement un comportement utile

Exemple : `Calculatrice` n'expose qu'une méthode publique
`executer(...)`.

------------------------------------------------------------------------

## 4. Abstraction

Abstraire signifie se concentrer sur le *quoi* plutôt que le *comment*.

`Operation` abstrait une règle de calcul. Les classes concrètes
implémentent le comportement.

------------------------------------------------------------------------

## 5. Interfaces et polymorphisme

Une interface définit un contrat.

Le polymorphisme permet d'utiliser différentes implémentations via une
référence commune.

Exemple : `Calculatrice` exécute une `Operation` sans connaître son type
concret.

------------------------------------------------------------------------

## 6. Héritage (usage réfléchi)

L'héritage n'est pas utilisé ici volontairement : - pas de comportement
commun pertinent - éviter le couplage fort

Préférence donnée aux interfaces.

------------------------------------------------------------------------

## 7. Constructeurs et injection

Un constructeur garantit qu'un objet est valide dès sa création.

Dans le projet : `Application` reçoit : - `UserInterface` -
`Calculatrice` - `OperationFactory` - `HistoriqueDAO`

Principe : \> Dépendre d'abstractions, pas d'implémentations.

------------------------------------------------------------------------

## 8. Patterns utilisés

### Strategy

Les opérations sont interchangeables.

### Factory

`OperationFactory` centralise la création des opérations.

### DAO

`HistoriqueDAO` sépare la logique métier de la persistance.

### Injection de dépendances

Les dépendances sont fournies via constructeur.

------------------------------------------------------------------------

## 9. Séparation des couches

ui → interaction utilisateur\
app → orchestration\
metier → logique métier\
persistence → stockage

Chaque couche a une responsabilité distincte.

------------------------------------------------------------------------

## 10. Gestion des erreurs

Deux catégories :

-   Erreurs métier → `OperationException`
-   Erreurs de saisie → `UserInputException`

Principe : - on lève l'erreur là où elle apparaît - on la traite là où
une décision est possible

------------------------------------------------------------------------

## 11. SOLID appliqué

-   S : une responsabilité par classe
-   O : ajout d'opération sans modifier l'existant
-   L : toute `Operation` est substituable
-   D : dépendances vers interfaces

------------------------------------------------------------------------

## 12. Règles personnelles à retenir

-   Une classe = une intention claire
-   Pas d'héritage par réflexe
-   Pas de getters/setters inutiles
-   Séparer orchestration et exécution
-   Les exceptions signalent un problème, elles ne pilotent pas la
    logique

------------------------------------------------------------------------

## Conclusion

Ce projet de calculatrice sert de support pour apprendre à penser objet
:

-   structurer avant de coder
-   découpler les responsabilités
-   concevoir pour l'évolution
-   écrire du code maintenable
