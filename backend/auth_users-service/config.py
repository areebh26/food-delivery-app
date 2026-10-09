import os
from functools import lru_cache

from dotenv import load_dotenv
from pydantic_settings import BaseSettings


load_dotenv()

class Settings(BaseSettings):
    port: int = os.getenv("PORT", 5000)

@lru_cache
def get_settings() -> Settings:
    return Settings()
