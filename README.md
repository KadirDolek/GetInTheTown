            GetinTheTown



Un jeu d'aventure textuel avec interface graphique développé en Java/Swing. Dans ce jeu, vous devez vaincre un gobelin pour pouvoir entrer dans la ville gardée par Messire Pudding.




Comment jouer

Ici le but est de rentrer dans la ville.

Naviguez dans le monde en choisissant différentes options rapides.
Découvrez des armes pour augmenter votre puissance d'attaque.
Combattez le gobelin.

Installation et exécution
Prérequis

Java JDK 8 ou supérieur installé sur votre machine

Option 1: Télécharger et exécuter le JAR

Téléchargez le fichier GetinTheTown.jar depuis la page des releases
Double-cliquez sur le fichier JAR ou exécutez la commande:
java -jar GetinTheTown.jar


Option 2: Compiler et exécuter depuis les sources
Pour Linux/macOS:

Clonez le dépôt:
git clone https://github.com/votre-username/GetinTheTown.git
cd GetinTheTown

Rendez le script d'exécution exécutable:
chmod +x run.sh

Exécutez le script:
./run.sh


Pour Windows:

Clonez le dépôt:
git clone https://github.com/votre-username/GetinTheTown.git
cd GetinTheTown

Double-cliquez sur run.bat ou exécutez-le depuis la ligne de commande:
run.bat


Compilation manuelle:

Compilez les fichiers sources:
javac -d bin src/*.java

Exécutez le programme:
java -cp bin Main


Structure du projet

src/: Contient les fichiers source Java

Main.java: Point d'entrée du programme
Game.java: Contient la logique du jeu et l'interface utilisateur


bin/: Dossier de sortie pour les fichiers compilés
lib/: Dossier pour les dépendances (vide pour le moment)


Licence
Ce projet est sous licence MIT - voir le fichier LICENSE pour plus de détails.
Dolek Kadir


