from abc import ABC, abstractmethod


class ADictionary(ABC):

    @abstractmethod
    def add(self, word: str):
        """Ajoute un mot au dictionnaire"""
        pass

    @abstractmethod
    def from_file(self, filepath: str):
        """Ajoute au dictionnaire tous les mots contenues dans un fichier"""
        pass

    @abstractmethod
    def contains(self, word: str) -> bool:
        """Vérifie si un mot appartient au dictionnaire"""
        pass
