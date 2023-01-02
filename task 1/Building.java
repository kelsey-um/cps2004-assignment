class Building {
    byte level;
}

interface ResourceGeneration{}

interface TroopGeneration{}

class Farm extends Building implements ResourceGeneration{}

class Lumbermill extends Building implements ResourceGeneration{}

class Forge extends Building implements ResourceGeneration{}

class Barracks extends Building implements TroopGeneration{}

class ArcheryRange extends Building implements TroopGeneration{}

class Stables extends Building implements TroopGeneration{}
