# Generates shaped ring recipe JSONs for ScalarRPGUtils
# Usage: run from project root:
# ruby src/main/resources/data/scalarrpgutils/recipe/rings/generate_ring_recipes.rb

require 'json'
require 'fileutils'

# Materials and their base ingredient (kept for reference; 'g' will be gold)
ingredient_map = {
  'copper' => 'minecraft:copper_ingot',
  'diamond' => 'minecraft:diamond',
  'emerald' => 'minecraft:emerald',
  'gold' => 'minecraft:gold_ingot',
  'lapis_lazuli' => 'minecraft:lapis_lazuli',
  'netherite' => 'minecraft:netherite_ingot',
  'quartz' => 'minecraft:quartz',
  'redstone_crystal' => 'minecraft:redstone_block'
}

out_dir = File.join(__dir__)
FileUtils.mkdir_p(out_dir)

materials = ingredient_map.keys
levels = [1,2,3]

# Pattern for rings: '#' = component, 'g' = gold
pattern = [
  '#g ',
  'g g',
  ' g '
]

puts "Generating ring recipes in: #{out_dir}"
count = 0
materials.each do |mat|
  levels.each do |lvl|
    component_id = "scalarrpgutils:#{mat}_component_level_#{lvl}"
    gold_item = 'minecraft:gold_ingot'

    recipe = {
      'type' => 'minecraft:crafting_shaped',
      'pattern' => pattern,
      'key' => {
        '#' => { 'item' => component_id },
        'g' => { 'item' => gold_item }
      },
      'result' => {
        'id' => "scalarrpgutils:#{mat}_ring_level_#{lvl}",
        'count' => 1
      }
    }

    filename = File.join(out_dir, "#{mat}_ring_level_#{lvl}.json")
    File.write(filename, JSON.pretty_generate(recipe) + "\n")
    puts "Wrote #{filename}"
    count += 1
  end
end

puts "Done: Generated #{count} ring recipes."
