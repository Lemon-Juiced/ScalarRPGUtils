# Generates simple item model JSON files for ScalarRPGUtils
# Usage: run this script from the project root or where Ruby can write to
# It will create files under src/main/resources/assets/scalarrpgutils/models/item/

require 'json'
require 'fileutils'

materials = %w[copper diamond emerald gold lapis_lazuli netherite quartz redstone_crystal]
types = %w[component gloves necklace ring]
levels = (1..3).to_a

out_dir = File.join(__dir__) # this script is already in models/item

puts "Generating model files in: #{out_dir}"

materials.each do |mat|
  types.each do |type|
    levels.each do |lvl|
      name = "#{mat}_#{type}_level_#{lvl}"
      filename = File.join(out_dir, "#{name}.json")

      # For components include the level in the texture name; for other types omit the level
      texture_name = if type == 'component'
                       name
                     else
                       "#{mat}_#{type}"
                     end

      model = {
        'parent' => 'item/generated',
        'textures' => {
          'layer0' => "scalarrpgutils:item/#{texture_name}"
        }
      }

      File.write(filename, JSON.pretty_generate(model) + "\n")
      puts "Wrote #{filename}"
    end
  end
end

puts "Done: Generated #{materials.size * types.size * levels.size} model files."
