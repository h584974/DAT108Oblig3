"use strict"

class DiceController {
	
	constructor (root) {
		this.root = root;
		this.run = this.run.bind(this);
		this.rollDice = this.rollDice.bind(this);
		this.dice = new Dice();
		this.diceoutput = null;
	}
	
	run() {
		const btRef=document.getElementById(this.root).querySelector("*[data-dicebutton]");
		btRef.addEventListener("click",this.rollDice,true);
		this.diceoutput = document.getElementById(this.root).querySelector("*[data-diceoutput]");
	}
	
	rollDice() {
		this.dice.roll();
		this.diceoutput.innerText = this.dice.value;
	}
}

const controller = new DiceController("root");
document.addEventListener("DOMContentLoaded",controller.run,true);