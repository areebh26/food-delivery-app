import uvicorn
from fastapi import FastAPI

from config import get_settings, Settings

settings : Settings = get_settings()
app = FastAPI(title="Tomato Auth Service")


@app.get("/")
def root():
    return {"message": "Auth service is running"}

if __name__ == "__main__":
    uvicorn.run(
        "main:app",
        host="localhost",
        port=settings.port,
        reload=True,
    )