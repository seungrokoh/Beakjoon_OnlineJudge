package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	in := bufio.NewReader(os.Stdin)
	line, _ := in.ReadString('\n')
	wordSlice := strings.Fields(line)
	fmt.Println(len(wordSlice))
}
