public class Buildings {
    
}

interface ResourceGeneration{}

interface TroopGeneration{}

class Farm extends Buildings implements ResourceGeneration{}

class Lumbermill extends Buildings implements ResourceGeneration{}

class Forge extends Buildings implements ResourceGeneration{}

class Barracks extends Buildings implements TroopGeneration{}

class ArcheryRange extends Buildings implements TroopGeneration{}

class Stables extends Buildings implements TroopGeneration{}
