# Generates shapeless component recipe JSONs for ScalarRPGUtils
# Usage: run from project or where Ruby can write to this directory:
# ruby generate_component_recipes.rb

require 'json'
require 'fileutils'

# Materials and their base ingredient item IDs. Redstone is a special case using redstone_block.
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

# Burnisher items per level (namespace scalarrpgutils)
burnishers = {
  1 => 'scalarrpgutils:iron_burnisher',
  2 => 'scalarrpgutils:diamond_burnisher',
  3 => 'scalarrpgutils:netherite_burnisher'
}

out_dir = File.join(__dir__)
FileUtils.mkdir_p(out_dir)

materials = ingredient_map.keys
levels = [1,2,3]

puts "Generating component recipes in: #{out_dir}"
count = 0
materials.each do |mat|
  levels.each do |lvl|
    ingredient_item = ingredient_map[mat]
    burnisher_item = burnishers[lvl]

    recipe = {
      'type' => 'minecraft:crafting_shapeless',
      'ingredients' => [
        { 'item' => ingredient_item },
        { 'item' => burnisher_item }
      ],
      'result' => {
        'id' => "scalarrpgutils:#{mat}_component_level_#{lvl}",
        'count' => 1
      }
    }

    filename = File.join(out_dir, "#{mat}_component_level_#{lvl}.json")
    File.write(filename, JSON.pretty_generate(recipe) + "\n")
    puts "Wrote #{filename}"
    count += 1
  end
end

puts "Done: Generated #{count} component recipes."
