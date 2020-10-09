from abc import ABC, abstractmethod
from typing import List


class AMain(ABC):

    @abstractmethod
    @staticmethod
    def main(args: List[str]):
        pass
