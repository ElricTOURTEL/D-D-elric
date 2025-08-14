🎲🐉 DnD Console — Jeu de rôle en ligne de commande (Java)

Un mini-RPG inspiré de Donjons & Dragons, jouable intégralement dans le terminal.





🧭 Aperçu

DnD Console est un jeu solo au tour par tour qui se joue dans la console. Créez un personnage (Guerrier, Magicien, etc.), explorez des rencontres aléatoires, combattez des ennemis, ramassez du butin et améliorez votre équipement.

Combat au tour par tour (initiative, attaque, critique, esquive)

Classes jouables avec compétences uniques

Système d’objets et d’armes (bonus / restrictions de classe)

Inventaire, or, marchands (optionnel), quêtes simples

Sauvegarde/chargement de partie

Journal des événements (log) pour débogage

ℹ️ Ce dépôt sert de squelette prêt à étendre. Adaptez les règles selon vos besoins.

🏗️ Architecture (proposée)

```
src/
 └─ main/java/com/example/dndconsole/
    ├─ App.java                  # point d'entrée
    ├─ core/                    # boucle de jeu, moteur, utilitaires
    ├─ character/               # Personnage, Classes, Stats
    ├─ combat/                  # logique de combat (dés, initiative, dégâts)
    ├─ items/                   # Item, Weapon, Armor, consommables
    ├─ io/                      # CLI, parsing des commandes, affichage
    ├─ data/                    # chargement JSON/YAML (armes, ennemis)
    └─ save/                    # persistance (JSON)

src/test/java/...               # tests unitaires
```

✅ Prérequis

Java 17+ (OpenJDK recommandé)

Gradle ou Maven (optionnel si vous compilez à la main)

(Optionnel) IntelliJ IDEA / VS Code pour le dev
