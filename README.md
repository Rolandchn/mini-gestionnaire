### Énoncé 
On considère un planning comme un ensemble de tâches, chacune possédant : un nom, une durée, et un ensemble de prédécesseurs.
On considère 4 types de liens pour les prédécesseurs :
- Fin-Début : Si A est prédécesseur de B, alors cela implique que B ne peux pas commencer tant que A n'est pas terminée
- Fin-Fin :  Si A est prédécesseur de B, alors cela implique que A et B doivent finir en même temps
- Début-Début : Si A est prédécesseur de B, alors cela implique que A et B doivent commencer en même temps
- Début-Fin : Si A est prédécesseur de B, alors cela implique que B ne peux pas se terminer tant que A n'a pas commencé

Également, un lien peu avoir ce qu'on appelle du lag, c'est à dire un décalage sur la contrainte appliquée par le lien.

Exemple : A est prédécesseur de B avec 1 jour de lag, cela signifie que B doit nécessairement commencer 1 jour après que 1 soit terminée.

## Cas obligatoire
En considérant les plannings utilisés dans les vidéos fournies, écrire un programme qui affichera les durée et le chemin critique de chacun des projets. 
Pour le cas obligatoire, on considère que tous les liens sont de type Fin-Début avec 0 de lag.
https://youtu.be/4oDLMs11Exs
https://youtu.be/G5sz_ucbb9A
https://youtu.be/lMWi96SjZ1Y
https://youtu.be/AGYdLUaZvDk
https://youtu.be/Ex_wD26Ixbc

## Cas optionnel
Même consigne que pour le cas obligatoire, avec cette fois-ci la possibilité d'avoir n'importe lequel des liens, et un lag entier positif ou négatif.


### Lancer le programme
Rentrez dans la classe Main.java pour lancer le programme.

Le programme se lancera sur Terminal.