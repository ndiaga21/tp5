from abc import ABC, abstractmethod
from typing import List

class ATrigrammes(ABC):

    @abstractmethod
    def add(self, word:str):
        """Ajoute tous les trigrammes de word, et word dans la liste de mot de chaque trigramme."""
        pass

    @abstractmethod
    def get_words(self, word:str) -> List[str]:
        """Retourne tous les mots ayant au moins un trigramme en commun."""
        pass
