# Generates shaped gloves recipe JSONs for ScalarRPGUtils
# Usage: run from project root:
# ruby src/main/resources/data/scalarrpgutils/recipe/gloves/generate_gloves_recipes.rb

require 'json'
require 'fileutils'

# Map materials to their base ingredient (special-case redstone_crystal uses redstone_block)
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

pattern = [
  'gg ',
  'g#g',
  ' gg'
]

puts "Generating gloves recipes in: #{out_dir}"
count = 0
materials.each do |mat|
  levels.each do |lvl|
    component_id = "scalarrpgutils:#{mat}_component_level_#{lvl}"
    # 'g' in the pattern stands for gold for all gloves
    base_item = 'minecraft:gold_ingot'

    recipe = {
      'type' => 'minecraft:crafting_shaped',
      'pattern' => pattern,
      'key' => {
        '#' => { 'item' => component_id },
        'g' => { 'item' => base_item }
      },
      'result' => {
        'id' => "scalarrpgutils:#{mat}_gloves_level_#{lvl}",
        'count' => 1
      }
    }

    filename = File.join(out_dir, "#{mat}_gloves_level_#{lvl}.json")
    File.write(filename, JSON.pretty_generate(recipe) + "\n")
    puts "Wrote #{filename}"
    count += 1
  end
end

puts "Done: Generated #{count} gloves recipes."
