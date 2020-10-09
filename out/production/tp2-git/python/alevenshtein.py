from abc import ABC, abstractmethod


class ALevenshtein(ABC):

    @abstractmethod
    @staticmethod
    def distance(word1: str, word2: str) -> int:
        """Calcule la distance d'édition entre deux mots"""
        pass
