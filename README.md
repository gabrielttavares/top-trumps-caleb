#top-trumps-caleb

A [Top Trumps](https://en.wikipedia.org/wiki/Top_Trumps) game based on characters from the Bible, made for my kids.

    Start[Start Game] --> ChoosePlayers[Choose Number of Players]
    ChoosePlayers --> DealCards[Deal Cards to Players]
    DealCards --> PlayerTurn[Player's Turn]    
    
    subgraph Round
            PlayerTurn --> ChooseStat[Choose a Stat]
            ChooseStat --> CompareStats[Compare Stats of All Players]
            CompareStats --> WinnerDecision{Is There a Winner for the Round?}
            WinnerDecision -- Yes --> AwardCards[Award Cards to Winner]
            WinnerDecision -- No --> Draw[Draw Round, Cards in Pool]
            AwardCards --> CheckGameOver
            Draw --> CheckGameOver
        end
        
    CheckGameOver{Are All Cards With One Player?}
    CheckGameOver -- Yes --> GameWinner[Declare Game Winner]
    CheckGameOver -- No --> NextTurn[Next Player's Turn]
    NextTurn --> PlayerTurn
    
    GameWinner --> End[End Game]
