DIR_PATH = ./src/org/h_naka/sudoku
OUT_DIR = ./bin

all :
	javac -Xlint:all -d $(OUT_DIR) $(DIR_PATH)/*.java
