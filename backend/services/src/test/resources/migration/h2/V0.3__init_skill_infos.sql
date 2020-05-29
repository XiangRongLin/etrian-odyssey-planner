-- noinspection SqlResolveForFile

INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (0, 'Hero', 'Brave Heart', 'For 3 turns, increases the chance of afterimage creation and all afterimage damage. The damage boost only applies while Force Boost is active.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (1, 'Hero', 'Miracle Edge', 'Deals melee cut damage to all enemies, and restores HP to all party members. This can restore HP over maximum HP. The overhealed amount is removed at the end of the turn.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (2, 'Hero', 'Afterimage', 'When the user (or an afterimage) attacks with a skill, there''s a chance to create an afterimage in an empty slot. The afterimage will attack with the same skill on the next turn, and vanish at the end of that turn. Does not activate for chases or counterattacks.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (3, 'Hero', 'Mirage Sword', 'Deals ranged cut damage to one target. Has a high chance to create an afterimage.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (4, 'Hero', 'Wide Bravery', 'Deals strong melee cut damage to one target. If this skill goes off before the target acts, including if the target could not act due to a bind or ailment, its range is extended to melee cut damage to all enemies.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (5, 'Hero', 'Frigid Slash', 'Deals melee cut+ice damage to one target, with splash damage.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (6, 'Hero', 'Encourage', 'When the user attacks with a skill, restores HP to all party members. HP restored is based on the user''s max HP. Does not activate for links, chases or counterattacks.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (7, 'Hero', 'Heroic Bonds', 'When all party members'' HP is above a set percentage, increases the user''s attack and action speed.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (8, 'Hero', 'Physical Shield', 'Deals melee bash damage to one target. It has a low action speed, but increases physical defense for all allies until it executes. Damage is based on the user''s shield''s DEF.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (9, 'Hero', 'Clear Mind', 'Removes binds and ailments and restores TP to the user. Cannot be used if the user has no ailment or binds, and will not restores TP if they were cured prior to this skill being used.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (10, 'Hero', 'Chop', 'Occasionally gains more items when using Chop points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (11, 'Hero', 'Charge Image', 'Removes all afterimages. Until the end of the next turn, increases the user''s attack and chance of creating afterimages. Number of afterimages consumed will not affect this skill''s effect.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (12, 'Hero', 'Graceful Image', 'When the user uses a skill while an afterimage is present, refunds a percentage of the TP used for the skill to the user.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (13, 'Hero', 'Shock Spark', 'Deals melee cut damage to one target, and follows up with ranged volt damage to all enemies. The higher the target''s cut resistance is, the higher the volt damage will be.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (14, 'Hero', 'Burst Blade', 'Deals multiple instances of melee cut damage to one target. Number of attacks is a random number between 2, and 3 plus the number of enemies present.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (15, 'Hero', 'Heroic Steel', 'When all party members'' HP is below a set percentage, increases the user''s defense and chance of being targeted.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (16, 'Hero', 'Great Bravery', 'When an ally whose HP is below a set percentage is attacked, the user has a chance to cover that ally. This skill will prioritize the user''s afterimage.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (17, 'Hero', 'Elemental Shield', 'Deals melee bash damage to one target. It has a low action speed, but increases elemental defense for all allies until it executes. Damage is based on the user''s shield''s DEF.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (18, 'Hero', 'Fervor', 'Transfers binds and ailments on allies in the user''s row to the user, and restores Force to the user. If no binds or ailments are transferred, Force will not increase.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (19, 'Hero', 'New Challenger', 'Immediately enters battle with an increased chance of encountering rare breeds, and a chance of entering consecutive battles. Fails if the current location has no encounters.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (20, 'Hero', 'Dark Image', 'Afterimages have a chance of not disappearing at the end of the turn.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (21, 'Hero', 'Act Breaker', 'Deals melee cut damage to one target. Attempts to inflict stun on the target. The higher the target''s HP is, the higher the chance of stun is.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (22, 'Hero', 'Regiment Rave', 'At the end of the turn, deals melee cut+fire damage to one target. Adds 40% of all damage dealt to the target this turn by all party members to this attack''s damage, up to a set limit.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (23, 'Hero', 'Force Gift', 'Deals melee cut damage to one target. Increases Force for allies on the user''s row instead of the user.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (24, 'Hero', 'Retain Force', 'When the user''s Force Boost times out, restores some Force to the user.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (25, 'Hero', 'Guard Rush', 'Reduces all damage to all party members for one turn, and deals melee bash damage to one target at the end of the turn. If the attack hits, this skill cannot be used again for a set number of turns. Damage is based on the user''s shield''s DEF, and the number of times damage is reduced. If no damage reduction took place, the attack will not happen.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (26, 'Protector', 'Shield Protect', 'For 3 turns, increases damage reduction from shield skills.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (27, 'Protector', 'Painless', 'This turn, completely negates all damaging attacks against the party.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (28, 'Protector', 'Front Guard', 'Reduces physical damage to the front row for one turn.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (29, 'Protector', 'Rear Guard', 'Reduces physical damage to the back row for one turn.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (30, 'Protector', 'Ally Shield', 'Covers one ally for one turn.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (31, 'Protector', 'Fortify', 'Increases the user''s defense for a set number of turns.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (32, 'Protector', 'Shield Smite', 'Deals melee bash damage to one target. Attempts to inflict arm bind. Damage is based on the user''s shield''s DEF.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (33, 'Protector', 'Taunt', 'Increases the user''s defense and chance of being targeted for a set number of turns.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (34, 'Protector', 'Preemptive Taunt', 'If Provoke is learned, there is a chance to automatically cast it at the start of battle. Cannot activate if another ally activated it first.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (35, 'Protector', 'Healing Wall', 'When the user defends, restores HP to allies on the user''s row.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (36, 'Protector', 'Chop', 'Occasionally gains more items when using Chop points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (37, 'Protector', 'Recovery Guard', 'Removes binds from one row, and reduces physical damage to that row for one turn.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (38, 'Protector', 'Aegis', 'There is a chance for the user to survive fatal damage at 1 HP. Can activate once per battle at most.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (39, 'Protector', 'Shield Bash', 'Deals melee bash damage to all enemies, and reduces their physical attack for 3 turns. Damage is based on the user''s shield''s DEF.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (40, 'Protector', 'Keep Guard', 'Reduces all damage to one ally until the end of the next turn, and disables all Guard skills until then.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (41, 'Protector', 'Phys DEF Up', 'Increases physical defense.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (42, 'Protector', 'Elem DEF Up', 'Increases elemental defense.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (43, 'Protector', 'Fire Wall', 'Reduces one instance of fire damage against all party members. Higher levels upgrade reduction to null, then absorb.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (44, 'Protector', 'Ice Wall', 'Reduces one instance of ice damage against all party members. Higher levels upgrade reduction to null, then absorb.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (45, 'Protector', 'Volt Wall', 'Reduces one instance of volt damage against all party members. Higher levels upgrade reduction to null, then absorb.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (46, 'Protector', 'HP Up', 'Increases maximum HP.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (47, 'Protector', 'Heal Guard', 'Restores HP for one row, and reduces physical damage to that row for one turn.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (48, 'Protector', 'Line Shield', 'Covers one row for one turn.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (49, 'Protector', 'En Garde', 'When the user is attacked, there is a chance to automatically reduce the damage.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (50, 'Protector', 'Shield Flare', 'Until the end of the next turn, when the user is attacked, they will counterattack with ranged fire damage. Damage is based on the user''s shield''s DEF.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (51, 'Protector', 'Full Guard', 'Reduces all damage to all party members for one turn. Cannot be used again for a set number of turns.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (52, 'Medic', 'Intensive Care', 'For 3 turns, increases the action speed of all actions, and the healing power of healing skills (including items). The TP cost of healing skills is halved.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (53, 'Medic', 'Healing Touch', 'Revives and removes ailments, binds and debuffs from all party members, and restores their HP.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (54, 'Medic', 'Healing', 'Restores HP to one ally.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (55, 'Medic', 'Line Heal', 'Restores HP to one row.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (56, 'Medic', 'Patch Up', 'Restores HP to all allies at the end of battle. Does not activate if the party flees.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (57, 'Medic', 'Refresh', 'Removes ailments from one ally. Higher level increases range to one row.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (58, 'Medic', 'Antibodies', 'Increases the user''s rate of recovery from binds and ailments.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (59, 'Medic', 'Revive', 'Revives one ally.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (60, 'Medic', 'Scavenge', 'Increases item drop rate.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (61, 'Medic', 'Head Bash', 'Deals melee bash damage to one target. Attempts to inflict head bind.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (62, 'Medic', 'Take', 'Occasionally gains more items when using Take points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (63, 'Medic', 'Delayed Heal', 'Restores HP to all party members at the start of the next turn. Cannot be used on consecutive turns. Ineffective if the user dies before the skill activates.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (64, 'Medic', 'Unbind', 'Removes binds from one ally. Higher levels increase range to one row.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (65, 'Medic', 'Group Therapy', 'For a set number of turns, increases the range of the user''s healing skills, but decreases healing power and action speed.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (66, 'Medic', 'Final Gift', 'When the user dies, restores HP to all allies.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (67, 'Medic', 'Auto-Revive', 'When an ally dies, there is a chance to automatically revive that ally.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (68, 'Medic', 'Star Drop', 'Deals melee bash damage to one target. Reduces their physical defense for 3 turns.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (69, 'Medic', 'Medical Rod', 'Deals melee bash damage to one target. Reduces their elemental defense for 3 turns.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (70, 'Medic', 'Safe Passage', 'For a set number of steps, nullifies damage tiles and muddy floors, and greatly reduces other sources of damage while exploring.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (71, 'Medic', 'Elem DEF Up', 'Increases elemental defense.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (72, 'Medic', 'Heal-All', 'Restores HP to all party members.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (73, 'Medic', 'Chase Heal', 'For one turn, automatically restores HP to allies when they are attacked for a set number of times. Every time this skill activates, its chance of activating decreases.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (74, 'Medic', 'Overheal', 'Medic skills in battle can restore HP over party members'' maximum HP by a set percentage. The overhealed amount is removed at the end of turn.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (75, 'Medic', 'Deja Vu', 'For a set number of turns, at the end of each turn, all party members will receive again the effect of the last Medic active skill they received, provided that they received at least one Medic active skill while Heal Deja Vu is active.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (76, 'Medic', 'Heavy Strike', 'Deals melee bash damage to one target.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (77, 'Medic', 'Staff Mastery', 'Increases physical attack and maximum TP when a staff is equipped.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (78, 'Survivalist', 'Illusory Formation', 'For 3 turns, increases all party members'' action speed and evasion.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (79, 'Survivalist', 'Mirage Arrow', 'Deals ranged stab damage to one target. Decreases their accuracy and forces them to go last for 3 turns.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (80, 'Survivalist', 'Power Shot', 'Deals ranged stab damage to one target, with line-piercing effects.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (81, 'Survivalist', 'Flame Arrow', 'Deals ranged stab+fire damage to one target.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (82, 'Survivalist', 'Blind Arrow', 'Deals ranged stab damage to one target. Attempts to inflict blind.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (83, 'Survivalist', 'Chain Dance', 'For one turn, increases the user''s evasion and chance of being targeted.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (84, 'Survivalist', 'Safe Passage', 'For a set number of steps, nullifies damage tiles and muddy floors, and greatly reduces other sources of damage while exploring.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (85, 'Survivalist', 'Risk Perception', 'There is a set chance that blindsides will be negated.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (86, 'Survivalist', 'Resuscitate', 'Restores HP to one ally. Can only be used in the field. Higher levels allow this skill to revive the target as well.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (87, 'Survivalist', 'Sorting Skill', 'Increases inventory size.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (88, 'Survivalist', 'Natural Instinct', 'Occasionally gains more items when using any gathering points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (89, 'Survivalist', 'Flank Shot', 'Deals ranged stab damage to one row.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (90, 'Survivalist', 'Finishing Shot', 'When the user attacks a target whose HP is below a set threshold, the user follows up with their weapon. Does not activate for links, chases or counterattacks.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (91, 'Survivalist', 'Multi-Shot', 'Deals 2 instances of ranged stab damage to one enemy.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (92, 'Survivalist', 'Drop Shot', 'Deals ranged stab damage to one target. Damage increases if the target is in the back row.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (93, 'Survivalist', 'Trickery', 'For a set number of turns, reduces the accuracy of one row of enemies.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (94, 'Survivalist', 'Cautious Steps', 'For a set number of steps, reduces encounter rate.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (95, 'Survivalist', 'Efficiency', 'For 5 turns, increases the HP restored by Medica and upgrades used by the user, and extends their range to one row.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (96, 'Survivalist', 'Speed Up', 'Increases accuracy, evasion and action speed.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (97, 'Survivalist', 'Quick Step', 'Selected ally acts first this turn.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (98, 'Survivalist', 'Disabling Shot', 'When the user attacks with a bow skill, attempts to inflict leg bind.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (99, 'Survivalist', 'Sagittarius Shot', 'On the third turn after using this skill, ranged stab damage is dealt to one target at the start of that turn. Attempts to inflict stun. Ineffective if the user dies before the skill activates.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (100, 'Survivalist', 'Hazy Arrow', 'Deals ranged stab damage to one target. Always hits. Can only be used if the user evaded an attack on the previous turn.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (101, 'Survivalist', 'Nature''s Blessing', 'There is a chance to obtain extra rare items when gathering.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (102, 'Survivalist', 'Scapegoat', 'Selected ally will cover all party members a set number of times this turn. Ineffective if that ally has leg bind.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (103, 'Survivalist', 'Sneak Attack', 'For a set number of steps, increases chance of preemptive attacks.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (104, 'Ronin', 'Musou', 'For 3 turns, stance duration will not decrease, and stances cannot be removed. In addition, the user gains the effect of all stances.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (105, 'Ronin', 'Issen', 'Deals ranged cut damage to all enemies. Attempts to inflict instant death. Chance of instant death is increased against targets at low HP.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (106, 'Ronin', 'Upper Stance', 'Increases attack when Upper Stance is active, and increases the duration of Upper Stance. At the start of each battle, the user automatically assumes the stance with the highest skill level.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (107, 'Ronin', 'Upward Slash', 'Deals melee cut damage to one target. Assumes Upper Stance after use. Critical hit if used during Upper Stance.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (108, 'Ronin', 'Clear Stance', 'Increases defense and Ronin skills'' infliction rate when Clear Stance is active, and increases the duration of Clear Stance. At the start of each battle, the user automatically assumes the stance with the highest skill level.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (109, 'Ronin', 'Charging Thrust', 'Deals melee stab damage to one target. Assumes Clear Stance after use. Critical hit if used during Clear Stance.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (110, 'Ronin', 'Drawing Stance', 'Increases accuracy, evasion and action speed when Drawing Stance is active, and increases the duration of Drawing Stance. At the start of each battle, the user automatically assumes the stance with the highest skill level.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (111, 'Ronin', 'Sheath Strike', 'Deals melee bash damage to one target. Assumes Drawing Stance after use. Critical hit if used during Drawing Stance.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (112, 'Ronin', 'Air Blade', 'Deals ranged cut damage to one target. Critical hit if used during any stance.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (113, 'Ronin', 'Arm Strike', 'Deals melee stab damage to one target. Attempts to inflict arm bind. Critical hit if used during any stance.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (114, 'Ronin', 'Mine', 'Occasionally gains more items when using Mine points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (115, 'Ronin', 'Breath', 'Restores HP to the user and allies adjacent to the user.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (116, 'Ronin', 'Helm Splitter', 'Requires any stance. Deals melee cut damage to one target. Low accuracy, ignores cut resistance. Reduces stance duration by 2 after use. Critical hit if used during Upper Stance.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (117, 'Ronin', 'Flame Grater', 'Deals melee cut+fire damage to one target. Critical hit if used during Upper Stance.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (118, 'Ronin', 'Haze Slash', 'Requires any stance. Deals melee cut damage to one target. Attempts to inflict sleep. Reduces stance duration by 2 after use. Critical hit if used during Clear Stance.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (119, 'Ronin', 'Lightning Stab', 'Deals melee stab+volt damage to one target. Critical hit if used during Clear Stance.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (120, 'Ronin', 'Horizontal Slice', 'Requires any stance. Deals melee cut damage to one row. Reduces stance duration by 2 after use. Critical hit if used during Drawing Stance.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (121, 'Ronin', 'Frigid Slash', 'Deals melee cut+ice damage to one target. Critical hit if used during Drawing Stance.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (122, 'Ronin', 'Duel', 'Increases damage when attacking enemies that the user attacked last turn.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (123, 'Ronin', 'Phys ATK Up', 'Increases physical attack.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (124, 'Ronin', 'Swallow Strike', 'Requires any stance. Deals multiple instances of melee cut damage to one target. Removes stance after use, and disables skills on the next turn. Critical hit if used during Upper Stance.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (125, 'Ronin', 'Stone Thrust', 'Requires any stance. Deals melee stab damage to one target. Attempts to inflict petrify. Removes stance after use, and disables skills on the next turn. Critical hit if used during Clear Stance.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (126, 'Ronin', 'Petal Scatter', 'Requires any stance. Deals ranged cut damage to all targets. Removes stance after use, and disables skills on the next turn. Critical hit if used during Drawing Stance. Deals less damage based on the number of targets.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (127, 'Ronin', 'Full Proficiency', 'Increases the effect of all stances.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (128, 'Ronin', 'Rouse Spirits', 'At the end of the turn, if a stance is active, restores TP to the user.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (129, 'Ronin', 'Speed Up', 'Increases accuracy, evasion and action speed.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (130, 'War Magus', 'War Edge Power', 'For 3 turns, War Edge skills can activate additional effects even against targets without an ailment.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (131, 'War Magus', 'Fairy Robe', 'Removes ailments and binds from all party members, and restores their HP. This turn, negates all binds, ailments, stun, instant death and debuffs against all party members.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (132, 'War Magus', 'War Heal', 'Restores HP to one ally at the start of the turn, then at the end of the turn.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (133, 'War Magus', 'War Heal Line', 'Restores HP to one row at the start of the turn, then at the end of the turn.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (134, 'War Magus', 'Random Disease', 'Attempts to inflict one of poison, paralyze, blind, sleep or curse on one target.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (135, 'War Magus', 'Strength Slash', 'Deals melee cut+almighty damage to one target. If the target has an ailment, decreases their attack for 7 turns.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (136, 'War Magus', 'Guard Slash', 'Deals melee cut+almighty damage to one target. If the target has an ailment, decreases their defense for 7 turns.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (137, 'War Magus', 'Displace', 'Removes ailments and binds from one ally, and attempts to inflict them on one enemy.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (138, 'War Magus', 'Vampire', 'When the user deals damage to an enemy with an ailment, restores HP to the user''s row. Can only activate once per turn.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (139, 'War Magus', 'Take', 'Occasionally gains more items when using Mine points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (140, 'War Magus', 'War Edge Mastery', 'User can use sword skills with staff. Increases maximum TP when a sword is equipped; increases damage when a staff is equipped.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (141, 'War Magus', 'War Revive', 'Revives one ally at the start of the turn, then attempts to revive them again at the end of the turn.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (142, 'War Magus', 'Artery', 'For 3 turns, automatically restores HP for all party members when they act, once per turn.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (143, 'War Magus', 'War Response', 'For 3 turns, automatically restores HP for all party members when the debuffed enemy acts, once per turn.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (144, 'War Magus', 'Headcut', 'Deals melee cut+almighty damage to one target. If the target has an ailment, attempts to inflict head bind.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (145, 'War Magus', 'Armcut', 'Deals melee cut+almighty damage to one target. If the target has an ailment, attempts to inflict arm bind.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (146, 'War Magus', 'Legcut', 'Deals melee cut+almighty damage to one target. If the target has an ailment, attempts to inflict leg bind.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (147, 'War Magus', 'Rouse', 'Increases the user''s Force gain based on the number of enemies with binds.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (148, 'War Magus', 'HP Up', 'Increases maximum HP.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (149, 'War Magus', 'Status DEF Up', 'Decreases the chance of being inflicted with binds and ailments.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (150, 'War Magus', 'War Heal All', 'Restores HP to all party members at the start of the turn, then at the end of the turn.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (151, 'War Magus', 'Barrier', 'For one turn, there is a chance to nullify binds, ailments and debuffs against all party members, up to a set number of times.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (152, 'War Magus', 'Ailing Slash', 'Deals melee cut+almighty damage to one target. If the target has an ailment, increases damage dealt.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (153, 'War Magus', 'Mind Drain', 'When the user deals damage to an enemy with both an ailment and a bind, restores TP to the user''s row. Can only activate once per turn.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (154, 'War Magus', 'Epidemic', 'User''s normal attack attempts to inflict poison, paralyze, blind, sleep and curse.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (155, 'War Magus', 'Phys ATK Up', 'Increases physical attack.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (156, 'Highlander', 'Hero Battle', 'For 3 turns, spear skills will have increased power, and restore HP to all party members based on damage dealt. Spear skills that activate instant death will still restore HP based on the damage that would have been dealt.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (157, 'Highlander', 'Gae Bolg', 'Deals ranged stab damage to all enemies, and restores TP to the user based on damage dealt.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (158, 'Highlander', 'Long Thrust', 'Deals ranged stab damage to one target.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (159, 'Highlander', 'Spear Assist', 'Deals melee stab damage to one target at the end of the turn. If an elemental attack was used by an ally beforehand, that element is added to the attack and its damage is increased. If more than one elemental attack was used, the most recent element applies.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (160, 'Highlander', 'Turning Tide', 'When the user defeats an enemy, restores HP to all party members.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (161, 'Highlander', 'Draining Thrust', 'Consumes the user''s HP to deal melee stab damage to the enemy front row.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (162, 'Highlander', 'Legion Thrust', 'Consumes the HP of all allies other than the user to deal melee stab damage to the enemy front row.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (163, 'Highlander', 'Spirit Shield', 'Consumes the user''s HP to increase the elemental defense of one row for a set number of turns.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (164, 'Highlander', 'Bloody Veil', 'When the user loses HP, increases defense until the end of the turn.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (165, 'Highlander', 'Mine', 'Occasionally gains more items when using Mine points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (166, 'Highlander', 'HP Up', 'Increases maximum HP.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (167, 'Highlander', 'Head Pierce', 'Deals melee stab damage to one target. Attempts to inflict head bind and instant death.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (168, 'Highlander', 'Draining Burst', 'Consumes the user''s HP to deal melee stab damage to all enemies.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (169, 'Highlander', 'Delayed Charge', 'Consumes the user''s HP to deal ranged stab damage to one target at the end of a set number of turns after. Damage is increased based on the number of turns passed before its activation. Ineffective if the user dies before the skill activates.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (170, 'Highlander', 'Legion Burst', 'Consumes the HP of all allies other than the user to deal melee stab damage to all enemies.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (171, 'Highlander', 'Blood Fortune', 'Consumes all party members'' HP to increase their infliction rate of binds and ailments for a set number of turns.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (172, 'Highlander', 'Battle Instinct', 'At the start of battle, there is a chance to cast a buff on all party members that negates ailments once for 3 turns. Cannot activate if another ally activated it first.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (173, 'Highlander', 'Bloody Offense', 'For a set number of turns, one row of allies will have increased attack, but lose HP every time they act.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (174, 'Highlander', 'Bloodlust', 'When the user loses HP, there is a chance that they will automatically attack with their weapon.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (175, 'Highlander', 'Phys DEF Up', 'Increases physical defense.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (176, 'Highlander', 'Spear Reversal', 'Deals melee stab damage to one target. Damage is increased if the target has higher percentage of HP remaining than the user.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (177, 'Highlander', 'Cross Charge', 'Consumes the user''s HP to deal melee stab damage to one target. If currently charging for Delayed Charge, activates it and increases Cross Charge''s damage.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (178, 'Highlander', 'Legion Charge', 'Consumes the HP of all allies other than the user to deal melee stab damage to one target.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (179, 'Highlander', 'Allied Bonds', 'If the user''s skill consumed the HP of allies on the user''s row, restores their TP at the end of the turn.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (180, 'Highlander', 'Black Sabbath', 'Deals ranged almighty damage to all enemies, and restores all party members'' HP based on damage dealt.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (181, 'Highlander', 'Phys ATK Up', 'Increases physical attack.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (182, 'Gunner', 'Double Action', 'For 3 turns, all gun skills will activate twice. The second activation will have reduced power, but no TP cost.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (183, 'Gunner', 'Riot Gun', 'Deals ranged stab damage to one target. Attempts to stun the target with a high chance of success.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (184, 'Gunner', 'Rapid Fire', 'Deals 3 instances of ranged stab damage to one target. Low accuracy.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (185, 'Gunner', 'Splash Shot', 'Deals ranged stab damage to one target, with splash damage.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (186, 'Gunner', 'Leg Snipe', 'Deals ranged stab damage to one target. Always hits. Attempts to inflict leg bind.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (187, 'Gunner', 'Arm Snipe', 'Deals ranged stab damage to one target. Always hits. Attempts to inflict arm bind.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (188, 'Gunner', 'Cover Support', 'When the user defends while in the back row, restores HP to the front row.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (189, 'Gunner', 'Shell Shock', 'For one turn, reduces attack, defense, accuracy and evasion for enemies in the back row, and attempts to inflict stun on them.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (190, 'Gunner', 'Medic Bullet', 'Restores HP and removes ailments from one ally.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (191, 'Gunner', 'Pop Flare', 'For 3 turns, increases accuracy for all allies.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (192, 'Gunner', 'Mine', 'Occasionally gains more items when using Mine points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (193, 'Gunner', 'Feint Shot', 'Deals ranged stab damage to one row, and reduces their evasion.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (194, 'Gunner', 'Scattershot', 'Deals ranged stab damage to all enemies.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (195, 'Gunner', 'Head Snipe', 'Deals ranged stab damage to one target. Always hits. Attempts to inflict head bind.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (196, 'Gunner', 'Act Quick', 'Until the end of the next turn, reduces TP usage and increases action speed.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (197, 'Gunner', 'Charged Shot', 'Deals ranged stab damage to one target. Low action speed, and the user will take double damage until the skill activates.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (198, 'Gunner', 'Preemptive Fire', 'If Shell Shock is learned, there is a chance to automatically cast it at the start of battle. Cannot activate if another ally activated it first.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (199, 'Gunner', 'Preemptive Flare', 'If Pop Flares is learned, there is a chance to automatically cast it at the start of battle. Cannot activate if another ally activated it first.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (200, 'Gunner', 'Penetrator', 'When attacking a single target, there is a chance that line-piercing effects will be added. Does not activate for skills with multiple instances of damage.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (201, 'Gunner', 'TP Up', 'Increases maximum TP.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (202, 'Gunner', 'Ricochet', 'Deals multiple instances of ranged stab damage to random targets. Low accuracy. Higher level increases the number of attacks.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (203, 'Gunner', 'Charged Fire', 'Deals ranged stab+fire damage to one target. Low action speed, and the user will take double damage until the skill activates.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (204, 'Gunner', 'Charged Ice', 'Deals ranged stab+ice damage to one target. Low action speed, and the user will take double damage until the skill activates.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (205, 'Gunner', 'Charged Volt', 'Deals ranged stab+volt damage to one target. Low action speed, and the user will take double damage until the skill activates.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (206, 'Gunner', 'Phys ATK Up', 'Increases physical attack.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (207, 'Gunner', 'Multi-Shot', 'Attack skills have a chance of activating twice. Does not activate for links, chases and counterattacks.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (208, 'Sovereign', 'Victory Vow', 'For 3 turns, increases Order skills'' range to all party members, and reduces their TP cost by half.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (209, 'Sovereign', 'Proof of Nobility', 'This turn, buffs on all allies cannot be removed, and buffs that enhance attack, defense, infliction chance, ailment and binds resistance, healing, accuracy and evasion are doubled in strength.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (210, 'Sovereign', 'Attack Order', 'For a set number of turns, increases attack for one row.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (211, 'Sovereign', 'Fire Arms', 'For a set number of turns, imbues one row of allies'' weapons with fire, and increases their fire-elemental attack.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (212, 'Sovereign', 'Freeze Arms', 'For a set number of turns, imbues one row of allies'' weapons with ice, and increases their ice-elemental attack.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (213, 'Sovereign', 'Shock Arms', 'For a set number of turns, imbues one row of allies'' weapons with volt, and increases their volt-elemental attack.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (214, 'Sovereign', 'Guard Order', 'For a set number of turns, increases defense for one row.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (215, 'Sovereign', 'Reinforce', 'When the user casts a buff, restores HP to all affected allies.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (216, 'Sovereign', 'Royal Veil', 'At the end of the turn, if the user''s HP is full, restores HP to all party members. Only one instance of this skill can activate per turn.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (217, 'Sovereign', 'Monarch March', 'During exploration, restores HP to all allies for every 3 steps taken.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (218, 'Sovereign', 'Take', 'Occasionally gains more items when using Take points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (219, 'Sovereign', 'Negotiation', 'Removes the oldest buff and debuff from one ally, and restores HP and TP to them based on the number of removals.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (220, 'Sovereign', 'Royal Dignity', 'Once per turn, when the user is damaged while having a buff active, their HP is restored.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (221, 'Sovereign', 'Royal Lineage', 'When the user is buffed, their TP is restored. Does not activate if the buff negated a debuff.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (222, 'Sovereign', 'Element Bomb I', 'Removes elemental imbue from one ally to deal ranged damage of that element to all enemies.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (223, 'Sovereign', 'Rally Order', 'For a set number of turns, increases maximum HP for one row.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (224, 'Sovereign', 'Protect Order', 'For a set number of turns, restores HP at the end of each turn for one row of allies.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (225, 'Sovereign', 'Prevent Order', 'For a set number of turns, one row of allies may negate binds or ailments once.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (226, 'Sovereign', 'Tactical Decree', 'This turn, allies with buffs will restore TP based on damage taken when they are attacked.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (227, 'Sovereign', 'Healing Decree', 'This turn, allies with buffs will restore HP based on damage dealt when they attack. Attacks that activate instant death will still restore HP based on the damage that would have dealt.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (228, 'Sovereign', 'Status DEF Up', 'Decreases the chance of being inflicted with binds and ailments.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (229, 'Sovereign', 'Element Bomb II', 'Removes elemental imbue from one ally to deal 3 instances of ranged damage of that element to random enemies.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (230, 'Sovereign', 'Clearance', 'Removes all buffs and debuffs from all allies and enemies, and restores HP and TP to all allies based on the number of removals.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (231, 'Sovereign', 'Dauntless Order', 'For a set number of turns, one row of allies may endure fatal damage once with a set amount of HP.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (232, 'Sovereign', 'Final Decree', 'Removes all buffs from self to increase attack and defense for all allies this turn. Can only be used if the user has 3 buffs.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (233, 'Sovereign', 'Renew', 'When the user removes their own buffs, there is a chance for the same buffs to be renewed for the user. Does not activate if the buff is timed out, removed by another ally, or negated by a debuff.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (234, 'Ninja', 'Diversion Gambit', 'For 3 turns, increases the user''s evasion and chance of being targeted.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (235, 'Ninja', 'Ninpo: Toxic Mist', 'Attempts to inflict poison on all enemies.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (236, 'Ninja', 'Ninpo: Daggers', 'Deals ranged stab damage to a set number of random targets. Can hit each target once at most. Attempts to inflict sleep.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (237, 'Ninja', 'Ninpo: Caltrops', 'This turn, when the selected row is attacked, counterattack with ranged slash damage and attempt to inflict poison.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (238, 'Ninja', 'Shadow Bind', 'Deals melee cut damage to one target. Attempts to inflict leg bind.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (239, 'Ninja', 'Bone Crusher', 'Deals melee bash damage to one target. Reduces their physical defense.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (240, 'Ninja', 'Reflexes', 'When the user evades an attack, their TP is restored.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (241, 'Ninja', 'Concealment', 'Increases evasion.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (242, 'Ninja', 'Ninpo: Mirage', 'Creates a decoy of the user in an empty slot. The decoy has added evasion and chance to be targeted.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (243, 'Ninja', 'Chop', 'Occasionally gains more items when using Chop points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (244, 'Ninja', 'Proficiency', 'Increases attack. At max level, melee attacks will hit for full damage and can always reach the enemy back row, even when the user is in the back.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (245, 'Ninja', 'Ninpo: Mirror', 'Attempts to inflict the ailments and binds present on one enemy to all enemies.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (246, 'Ninja', 'Izuna', 'Deals melee cut damage to one target. Attempts to inflict petrify.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (247, 'Ninja', 'Hawk Strike', 'Deals multiple instances of melee cut damage to random targets.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (248, 'Ninja', 'Revenge Bomb', 'Once per battle, when the user is killed by an enemy attack, they will counterattack with ranged fire damage.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (249, 'Ninja', 'Ninpo: Double', 'Consumes a percentage of the user''s HP and TP to create a clone in an empty slot. Force Boost and Force Break are unusable while a clone is active.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (250, 'Ninja', 'Beheading', 'Normal attacks have a chance to inflict instant death.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (251, 'Ninja', 'Ninpo: Flight', 'This turn, the user has a high chance of evading physical attacks. Each time the user evades an attack, the evasion boost is reduced.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (252, 'Ninja', 'Auto-Mirage', 'If Ninpo: Mirage is learned, there is a chance to automatically cast it at the start of battle. Cannot activate if another ally activated it first.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (253, 'Ninja', 'Status ATK Up', 'Increases the chance of inflicting binds and ailments.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (254, 'Ninja', 'Ninpo: Panic', 'Attempts to inflict panic on all enemies.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (255, 'Ninja', 'Return Malice', 'If the user evaded an attack on the previous turn, increases chance of inflicting ailments', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (256, 'Ninja', 'Dominance', 'Deals melee cut damage to one target. Always hits. If target has an ailment, increases the user''s Force.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (257, 'Ninja', 'Drawing Slice', 'Deals multiple instances of melee damage to random targets, based on the number of clones active. All clones will disappear after use.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (258, 'Ninja', 'Ninpo: Smoke', 'Consumes the user''s HP to greatly increase their evasion for 3 turns.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (259, 'Ninja', 'Mystic Calm', 'Reduces TP cost. Will not reduce cost to 0.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (260, 'Zodiac', 'Divination', 'For 3 turns, Zodiac attack skills will have increased power, and restore half of their TP cost to the user.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (261, 'Zodiac', 'Astrosign', 'Deals ranged fire+ice+volt damage to all enemies. On this turn, all allies'' TP cost will be reduced to 0.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (262, 'Zodiac', 'Etheric Gleam', 'For a set number of turns, increases elemental attack for one row.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (263, 'Zodiac', 'Fire Star', 'Deals ranged fire damage to one target, with splash damage.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (264, 'Zodiac', 'Ice Star', 'Deals ranged ice damage to one target, with line-piercing effects.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (265, 'Zodiac', 'Volt Star', 'Deals ranged volt damage to one row.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (266, 'Zodiac', 'Singularity', 'Increases damage dealt when hitting weaknesses.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (267, 'Zodiac', 'Etheric Charge', 'Until the end of the next turn, Zodiac attack skills will hit only one target, but deal increased damage.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (268, 'Zodiac', 'Etheric Return', 'When the user kills an enemy, their TP is restored.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (269, 'Zodiac', 'Mine', 'Occasionally gains more items when using Mine points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (270, 'Zodiac', 'Horoscope', 'For a set number of turns, reduces encounter rate.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (271, 'Zodiac', 'Ether Mastery', 'Increases damage of Zodiac attack skills.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (272, 'Zodiac', 'TP Up', 'Increases maximum TP.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (273, 'Zodiac', 'Binary Fire', 'Deals ranged fire damage to all enemies.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (274, 'Zodiac', 'Binary Ice', 'Deals ranged ice damage to all enemies.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (275, 'Zodiac', 'Binary Volt', 'Deals ranged volt damage to all enemies.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (276, 'Zodiac', 'Etheric Boon', 'Increases attack based on the number of TP spent on the previous turn. Does not activate if TP spent last turn is too low.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (277, 'Zodiac', 'Anti-Ether', 'Provides a chance to nullify elemental attacks against the user''s row.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (278, 'Zodiac', 'Dark Ether', 'This turn, reduces TP usage for one row.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (279, 'Zodiac', 'Ether Shot', 'Deals ranged, INT-based damage to one enemy with the user''s weapon.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (280, 'Zodiac', 'Fire Prophecy', 'Prevents fire-elemental attacks from one enemy. If an attack is prevented, increases the user''s attack until the end of the next turn.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (281, 'Zodiac', 'Ice Prophecy', 'Prevents ice-elemental attacks from one enemy. If an attack is prevented, increases the user''s attack until the end of the next turn.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (282, 'Zodiac', 'Volt Prophecy', 'Prevents volt-elemental attacks from one enemy. If an attack is prevented, increases the user''s attack until the end of the next turn.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (283, 'Zodiac', 'Free Energy', 'Provides a chance to reduce the user''s TP usage to 0.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (284, 'Zodiac', 'Multi-Strike Ether', 'Until the end of the next turn, Zodiac attack skills will deal reduced damage, but hit random targets 2-5 times. Meteor will instead hit 6-15 times.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (285, 'Zodiac', 'Meteor', 'Deals 2-5 instances of ranged bash damage to random targets.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (286, 'Farmer', 'Item Echo', 'For 3 turns, any items used by the user will take effect twice. The second activation will not consume another item.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (287, 'Farmer', 'Final Secret', 'Fully restores all allies'' Force gauges, and any broken Force gauges have a chance to be repaired.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (288, 'Farmer', 'Sympathy Pain', 'Attempts to inflict ailments and binds on the user to all enemies. This will not remove them from the user.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (289, 'Farmer', 'Strange Seeds', 'At the end of this turn, attempts to inflict one of head bind, arm bind and leg bind to all enemies.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (290, 'Farmer', 'Play Possum', 'For 3 turns, decreases one ally''s chance of being targeted.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (291, 'Farmer', 'Keen Eye', 'For a set number of steps, displays treasure chests, hidden passages, staircases, FOEs and gather points on the minimap.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (292, 'Farmer', 'Excavation', 'During exploration, provides a chance to receive gatherable items when walking.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (293, 'Farmer', 'Flee', 'Consumes HP from all party members to attempt to flee the battle and return to the last used staircase or geomagnetic pole. Does not consume HP if fleeing failed.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (294, 'Farmer', 'Slap Awake', 'Revives one ally. Can only be used in the field.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (295, 'Farmer', 'Harvestry', 'Occasionally gains more items when using any gathering points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (296, 'Farmer', 'Earth''s Bounty', 'Increases experience gain for all party members while the user is alive.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (297, 'Farmer', 'Rotten Egg', 'For 3 turns, decreases attack for all enemies. Effect is stronger against enemies with an ailment.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (298, 'Farmer', 'Persistence', 'At the end of the turn, the user has a chance of automatically reviving.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (299, 'Farmer', 'Waste Not', 'Increases item drop rate.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (300, 'Farmer', 'Godsend', 'During exploration, provides a chance to receive consumable items when walking.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (301, 'Farmer', 'Rain or Shine', 'For a set number of steps, nullifies damage tiles and muddy floors, and greatly reduces other sources of damage while exploring.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (302, 'Farmer', 'Safe Stroll', 'For a set number of steps, reduces encounter rate.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (303, 'Farmer', 'Share the Wealth', 'Consumes the user''s TP to restore TP to other allies on the same row.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (304, 'Farmer', 'Fearless', 'If the user is in the front row and at full HP, their TP is restored at the end of the turn.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (305, 'Farmer', 'Survival Wisdom', 'Restores HP and TP to all party members when gathering.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (306, 'Farmer', 'Lullaby', 'Inflicts sleep on the user and attempts to inflict sleep on all enemies.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (307, 'Farmer', 'Fruitful Song', 'During exploration, restores TP to all allies every set number of steps taken.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (308, 'Farmer', 'Blessed Remains', 'When the user kills an enemy, restores Force to all party members.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (309, 'Farmer', 'Harvest Festival', 'Deals melee cut damage to all enemies. Increases damage dealt and attempts to inflict instant death on enemy with binds.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (310, 'Farmer', 'Nature''s Blessing', 'There is a chance to obtain additional rare items when gathering.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (311, 'Farmer', 'Double Crop', 'When gathering, there is a chance to immediately gather again from the same spot. Can only activate once per gather.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (312, 'Shogun', 'Unified Effort', 'For 3 turns, increases maximum HP and attack for all party members.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (313, 'Shogun', 'Decoy Party', 'This turn, all party members will negate any hostile action once.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (314, 'Shogun', 'Second Sword', 'Increases physical defense when two weapons are equipped. Enables sub-weapon when this skill is learned.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (315, 'Shogun', 'Echoing Slash', 'Deals melee damage to one target with the equipped katana at the start of turn. If two weapons are equipped, attacks again with the other weapon after the target acts.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (316, 'Shogun', 'Front Command', 'This turn, when the selected ally is attacked, all front row allies will counterattack with their weapons. Does not activate against counterattacks.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (317, 'Shogun', 'Bolt Slash', 'Deals melee cut+volt damage to one target.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (318, 'Shogun', 'Avidya Sight', 'Increases the user''s attack at night or when blinded.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (319, 'Shogun', 'Great Warrior', 'For 3 turns, increases one ally''s physical attack and chance of being targeted.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (320, 'Shogun', 'Taunt Assassins', 'For a set number of steps, increases encounter rate and experience gained from defeating enemies.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (321, 'Shogun', 'Take', 'Occasionally gains more items when using Take points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (322, 'Shogun', 'Morale Boost', 'When the user is revived, restores HP to all allies.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (323, 'Shogun', 'Twin Swallow', 'Deals melee damage to one target with the user''s weapon. If two weapons are equipped, this skill will hit twice. First hit will be from the katana, while the second hit will be from the other weapon.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (324, 'Shogun', 'Endure Command', 'This turn, when the user is attacked, all allies other than the user will counterattack with their weapons. Does not activate against counterattacks.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (325, 'Shogun', 'Blitz Command', 'All allies other than the user will attack one target with their weapons.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (326, 'Shogun', 'Morning Star', 'Deals melee cut damage to one row. Damage increases during the day.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (327, 'Shogun', 'Twilight Hour', 'Deals melee cut damage to one target. Damage increases at night.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (328, 'Shogun', 'Bloody Lance', 'When the user kills an enemy or ally, their attack is increased. The effect is reset when the user dies.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (329, 'Shogun', 'Reincarnation', 'On the turn when the user''s HP reaches 0, there is a chance that they may revive at the end of that turn.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (330, 'Shogun', 'Peerless Demon', 'Increases damage dealt for each hit you make in the same turn.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (331, 'Shogun', 'Seppuku', 'Restores HP to all other allies with a chance to revive them, but the user dies. This self-inflicted death cannot be prevented via any means.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (332, 'Shogun', '5-Ring Sword', 'Deals multiple instances of melee damage to random targets with user''s weapon. If two weapons are equipped, the maximum number of hits will double, and this attack will alternate between the katana and the other weapon.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (333, 'Shogun', 'Shot Command', 'This turn, when the selected row is attacked, all allies equipped with a bow or gun will counterattack with their bow or gun. Does not activate against counterattacks.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (334, 'Shogun', 'Warrior Might', 'This turn, the user will chase all attacks from all allies, but will lose HP for every chase. The HP loss can kill the user. Links, chases and counterattacks cannot be chased. Only one chase will be made for each action.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (335, 'Shogun', 'Curse Strike', 'Deals melee bash damage to one target. Attempts to inflict curse and arm bind.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (336, 'Shogun', 'Execution', 'When any enemy or ally is attacked, and their HP falls below a set percentage, there is a chance to inflict instant death to them.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (337, 'Shogun', 'Swift Justice', 'For 3 turns, increases one ally''s physical attack and action speed, but decreases their physical defense.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (338, 'Landsknecht', 'Trinity', 'For 3 turns, increases the user''s attack, accuracy and action speed.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (339, 'Landsknecht', 'Full Charge', 'This turn, the user is fully immune to any hostile effects from enemies. Until the end of the next turn, increases the user''s attack and action speed.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (340, 'Landsknecht', 'Proficiency', 'After the user attacks this turn, all further attacks against enemies attacked by the user will have increased damage and accuracy.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (341, 'Landsknecht', 'Falcon Slash', 'Deals melee damage to one target with the user''s weapon at the start of the turn.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (342, 'Landsknecht', 'Blazing Link', 'Deals melee cut/stab+fire damage to one target. If the target is attacked again after, follows up with another attack of the same element. Chance of follow-up decreases with each hit.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (343, 'Landsknecht', 'Freezing Link', 'Deals melee cut/stab+ice damage to one target. If the target is attacked again after, follows up with another attack of the same element. Chance of follow-up decreases with each hit.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (344, 'Landsknecht', 'Electric Link', 'Deals melee cut/stab+volt damage to one target. If the target is attacked again after, follows up with another attack of the same element. Chance of follow-up decreases with each hit.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (345, 'Landsknecht', 'Vanguard', 'For 5 turns, decreases the user''s physical defense, but increases physical attack and action speed.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (346, 'Landsknecht', 'Power Break', 'Deals melee bash damage to one target. Decreases their attack for 3 turns. Damage is based on the user''s shield''s DEF.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (347, 'Landsknecht', 'Mine', 'Occasionally gains more items when using Mine points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (348, 'Landsknecht', 'Phys DEF Up', 'Increases physical defense.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (349, 'Landsknecht', 'Double Strike', 'Deals 2 instances of melee damage to one target with the user''s weapon.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (350, 'Landsknecht', 'Spiral Slice', 'Deals melee cut damage to one target, with splash damage.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (351, 'Landsknecht', 'Penetrate', 'Deals melee stab damage to one target, with line-piercing effects.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (352, 'Landsknecht', 'Improved Link', 'For 3 turns, increases the number of follow-ups that can be made from link skills used by the user, as well as their chance of follow-up. Each action may trigger at most 4 link follow-ups.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (353, 'Landsknecht', 'Smash Link', 'Link follow-up attacks can deal critical hits. If an action triggered multiple follow-ups and one of them dealt a critical hit, all subsequent follow-ups triggered by that action will automatically deal critical hits as well.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (354, 'Landsknecht', 'Guard Break', 'Deals melee bash damage to one target. Decreases their defense for 3 turns. Damage is based on the user''s shield''s DEF.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (355, 'Landsknecht', 'Speed Break', 'Deals melee bash damage to one target. Decreases their evasion and action speed for 3 turns. Damage is based on the user''s shield''s DEF.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (356, 'Landsknecht', 'Initiative', 'When attacking before any enemies act, increases damage and accuracy.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (357, 'Landsknecht', 'Status DEF Up', 'Decreases the chance of being inflicted with binds and ailments.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (358, 'Landsknecht', 'Sword Tempest', 'Deals melee cut damage to one target. High power at the cost of speed.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (359, 'Landsknecht', 'Swift Stab', 'Deals multiple instances of melee stab damage to random targets.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (360, 'Landsknecht', 'Link Mastery', 'For each link follow-up made this turn, increases the damage of subsquent link follow-ups.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (361, 'Landsknecht', 'Link Finale', 'Deals melee damage to one target with the user''s weapon. Damage is based on the number of link follow-ups made on the previous turn.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (362, 'Landsknecht', 'Full Break', 'Deals melee bash damage to one target. Damage is increased if the target has a Break skill debuff. Multiple Break debuffs will not increase damage further. Damage is based on the user''s shield''s DEF.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (363, 'Landsknecht', 'Single Devotion', 'Increases damage when fewer elements are used in an attack.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (364, 'Nightseeker', 'Killing Intent', 'For 3 turns, increases attack and ailment infliction chance for the user.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (365, 'Nightseeker', 'Disaster', 'Deals melee cut damage to one target. If the target has an ailment, increases the ailment''s duration.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (366, 'Nightseeker', 'Sand Throw', 'Deals ranged cut damage to one target. Attempts to inflict blind.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (367, 'Nightseeker', 'Sleep Throw', 'Deals ranged cut damage to one target. Attempts to inflict sleep.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (368, 'Nightseeker', 'Shadow Cloak', 'For 3 turns, negates one physical attack made against the user.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (369, 'Nightseeker', 'Biding Slice', 'Deals melee cut damage to one target. If the user is not damaged until the end of the turn, deals melee cut damage to the same target again.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (370, 'Nightseeker', 'Ice Knife', 'Deals cut+ice damage to one target.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (371, 'Nightseeker', 'Proficiency', 'Increases damage dealt to enemies with ailments.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (372, 'Nightseeker', 'Decoy Sign', 'For 3 turns, increases one ally''s chance of being targeted.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (373, 'Nightseeker', 'Blade Flurry', 'User can attack with both weapons if two weapons are equipped. Damage of the second attack is based on this skill''s level. Enables sub-weapon when this skill is learned.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (374, 'Nightseeker', 'Chop', 'Occasionally gains more items when using Chop points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (375, 'Nightseeker', 'Curse Throw', 'Deals ranged cut damage to one target. Attempts to inflict curse.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (376, 'Nightseeker', 'Nerve Throw', 'Deals ranged cut damage to one target. Attempts to inflict paralysis.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (377, 'Nightseeker', 'Shadow Bite', 'Deals melee cut damage to one target. Damage is increased if the target has an ailment.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (378, 'Nightseeker', 'Auto-Cloak', 'If Shadow Cloak is learned, there is a chance to automatically cast it at the start of battle. Cannot activate if another ally activated it first.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (379, 'Nightseeker', 'Backstab', 'Deals melee cut damage to one target. Attempts to inflict head bind. If the user has Shadow Cloak, add almighty element to the attack and increases damage.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (380, 'Nightseeker', 'Sneak Attack', 'For a set number of steps, increases the chance of preemptive attacks.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (381, 'Nightseeker', 'Foul Mastery', 'Increases attack every time the user inflicts an ailment. Bonus stacks up to 3 times, and is reset if the user dies.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (382, 'Nightseeker', 'Speed Up', 'Increases accuracy, evasion and action speed.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (383, 'Nightseeker', 'Spread Throw', 'Until the end of the next turn, increases throw skills'' range to all targets, and improves their infliction rate.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (384, 'Nightseeker', 'Venom Throw', 'Deals ranged cut damage to one target. Attempts to inflict poison.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (385, 'Nightseeker', 'Swift Edge', 'Deals 3-5 instances of melee cut damage to one target. If the target has an ailment, maximum number of attacks is increased to 9.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (386, 'Nightseeker', 'Assassinate', 'Deals melee cut damage to one target. If the user has Shadow Cloak, attempts to inflict instant death.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (387, 'Nightseeker', 'Enduring Cloak', 'When Shadow Cloak negates an attack, there is a chance that Shadow Cloak will be automatically cast on the user.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (388, 'Nightseeker', 'Follow Trace', 'After using an attack skill, if at least one of the skill''s targets has an ailment, there is a chance to repeat the skill.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (389, 'Nightseeker', 'Auto-Spread', 'If Spread Throw is learned, there is a chance to automatically cast it at the start of battle. Cannot activate if another ally activated it first.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (390, 'Arcanist', 'Circle Paradise', 'For 3 turns, increases the user''s bind and ailment infliction chance, and prevents circles from being removed.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (391, 'Arcanist', 'Releasal Spell', 'Remove buffs and accumulative resistance from all enemies.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (392, 'Arcanist', 'Circle Boon', 'If a circle is active, restores HP to all party members at the end of the turn.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (393, 'Arcanist', 'Dismiss Heal', 'Dismisses the current circle and restores HP to all party members.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (394, 'Arcanist', 'Chain Circle', 'Activates a circle that attempts to inflict arm bind on all enemies at the end of each turn for 3 turns. Existing circle will be overwritten, and the circle is removed if the user dies.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (395, 'Arcanist', 'Snare Circle', 'Activates a circle that attempts to inflict leg bind on all enemies at the end of each turn for 3 turns. Existing circle will be overwritten, and the circle is removed if the user dies.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (396, 'Arcanist', 'Nerve Circle', 'Activates a circle that attempts to inflict paralysis on all enemies at the end of each turn for 3 turns. Existing circle will be overwritten, and the circle is removed if the user dies.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (397, 'Arcanist', 'Curse Circle', 'Activates a circle that attempts to inflict curse on all enemies at the end of each turn for 3 turns. Existing circle will be overwritten, and the circle is removed if the user dies.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (398, 'Arcanist', 'Bracing Walk', 'During exploration, restores HP to all allies for every 3 steps taken.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (399, 'Arcanist', 'Proficiency', 'Restores TP to the user when a circle is dismissed or times out.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (400, 'Arcanist', 'Chop', 'Occasionally gains more items when using Chop points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (401, 'Arcanist', 'Dismiss Revive', 'Dismisses the current circle to attempt to revive one row of allies.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (402, 'Arcanist', 'Dismiss Blow', 'Dismisses the current circle to deal ranged almighty damage to one target.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (403, 'Arcanist', 'Hood Circle', 'Activates a circle that attempts to inflict head bind on all enemies at the end of each turn for 3 turns. Existing circle will be overwritten, and the circle is removed if the user dies.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (404, 'Arcanist', 'Sleep Circle', 'Activates a circle that attempts to inflict sleep on all enemies at the end of each turn for 3 turns. Existing circle will be overwritten, and the circle is removed if the user dies.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (405, 'Arcanist', 'Charm Eye', 'For 3 turns, decreases attack for all enemies.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (406, 'Arcanist', 'Atrophic Eye', 'For 3 turns, decreases defense for all enemies.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (407, 'Arcanist', 'Status ATK Up', 'Increases the chance of inflicting binds and ailments.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (408, 'Arcanist', 'Tame Ground', 'For a set number of steps, nullifies damage tiles and muddy floors, and greatly reduces other sources of damage while exploring.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (409, 'Arcanist', 'Warding Mist', 'Provides a chance to nullify binds, ailments and stun for the user''s row.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (410, 'Arcanist', 'Dismiss Blast', 'Dismisses the current circle to deal ranged almighty damage to all enemies.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (411, 'Arcanist', 'Circle Mastery', 'Increases the power of Dismiss skills.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (412, 'Arcanist', 'Poison Circle', 'Activates a circle that attempts to inflict poison on all enemies at the end of each turn for 3 turns. Existing circle will be overwritten, and the circle is removed if the user dies.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (413, 'Arcanist', 'Chaos Circle', 'Activates a circle that attempts to inflict panic on all enemies at the end of each turn for 3 turns. Existing circle will be overwritten, and the circle is removed if the user dies.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (414, 'Arcanist', 'Dismiss Quake', 'Dismisses the current circle to attempt to inflict stun on all enemies.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (415, 'Arcanist', 'TP Return', 'Restores TP to the user when they inflict a bind, ailment or stun. Inflicting something on multiple enemies will not increase the effect of this skill.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (416, 'Imperial', 'Ignition', 'For 3 turns, the user''s drive skills will not activate the overheat state.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (417, 'Imperial', 'Conversion', 'Restores TP to the user. This can restore TP over maximum TP. The overhealed TP will disappear at the end of battle, or when the user dies.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (418, 'Imperial', 'Sharp Edge', 'Activation skill. Deals melee cut damage to one target. Reduces overheat duration by 1 turn.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (419, 'Imperial', 'Natural Edge', 'Activation skill. Deals melee damage to one target with the user''s weapon.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (420, 'Imperial', 'Blood Edge', 'Connecting skill. Deals melee cut damage to one target. Restores HP to the user based on the amount of damage dealt. Can only be used if an activation skill was used on the previous turn.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (421, 'Imperial', 'Heavy Guard', 'For 3 turns, increases defense for one ally, but that ally will move last each turn.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (422, 'Imperial', 'Assault Drive', 'Deals melee cut damage to one target, and places the user in the overheat state for 7 turns. Cannot be used while overheated. Low action speed, and the user will take double damage until the skill activates.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (423, 'Imperial', 'Heat Sink', 'Reduces overheat duration by a set number of turns. Can only be used while overheated.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (424, 'Imperial', 'Heat Shield', 'While overheated, increases the user''s defense.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (425, 'Imperial', 'Avenger', 'When an ally dies, restores HP to the user.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (426, 'Imperial', 'Mine', 'Occasionally gains more items when using Mine points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (427, 'Imperial', 'Massive Edge', 'Activation skill. Deals melee cut damage to one target, with splash damage.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (428, 'Imperial', 'Cool Edge', 'Connecting skill. Deals melee cut damage to one target. Reduces duration of overheat by 2 turns. Can only be used if an activation skill was used on the previous turn.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (429, 'Imperial', 'Trip Edge', 'Activation skill. Deals melee cut damage to one target. Attempts to inflict leg bind.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (430, 'Imperial', 'Impulse Edge', 'Connecting skill. Deals melee cut damage to one target. Restores TP to the user. Can only be used if an activation skill was used on the previous turn.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (431, 'Imperial', 'Intercooler', 'Increases the damage of Drive skills. Increasing this skill''s level will also reduce the duration of the overheat state.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (432, 'Imperial', 'Flame Drive', 'Deals melee cut+fire damage to one target, and places the user in the overheat state for 8 turns. Cannot be used while overheated. Low action speed, and the user will take double damage until the skill activates.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (433, 'Imperial', 'Freeze Drive', 'Deals melee cut+ice damage to one target, and places the user in the overheat state for 8 turns. Cannot be used while overheated. Low action speed, and the user will take double damage until the skill activates.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (434, 'Imperial', 'Shock Drive', 'Deals melee cut+volt damage to one target, and places the user in the overheat state for 8 turns. Cannot be used while overheated. Low action speed, and the user will take double damage until the skill activates.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (435, 'Imperial', 'Status DEF Up', 'Decreases the chance of being inflicted with binds and ailments.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (436, 'Imperial', 'Charge Edge', 'Terminating skill. Deals melee cut damage to one target. Until the end of the next turn, increases the user''s attack. Can only be used if an activation skill or connecting skill was used on the previous turn.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (437, 'Imperial', 'Force Edge', 'Terminating skill. Deals melee cut damage to one target. Restores Force to the user. Can only be used if an activation skill or connecting skill was used on the previous turn.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (438, 'Imperial', 'HP Up', 'Increases maximum HP.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (439, 'Imperial', 'Accel Drive', 'Deals melee cut+almighty damage to one target, and places the user in the overheat state for 9 turns. Cannot be used while overheated. Low action speed, and the user will take double damage until the skill activates.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (440, 'Imperial', 'Absorber', 'Restores TP to the user when hitting a weakness.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (441, 'Imperial', 'Elem ATK Up', 'Increases elemental attack.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (442, 'Pugilist', 'Bind Rush', 'For 3 turns, increases the user''s bind infliction chance, and chases any of the user''s attacks against an enemy with binds, ailments or stun. Multi-hit attacks will only be chased once.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (443, 'Pugilist', 'Final Blow', 'Deals melee bash damage to one target. Attempts to inflict head bind, arm bind and leg bind.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (444, 'Pugilist', 'Concussion', 'Deals melee bash damage to one target. Attempts to inflict head bind.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (445, 'Pugilist', 'Arm Breaker', 'Deals melee bash damage to one target. Attempts to inflict arm bind.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (446, 'Pugilist', 'Low Blow', 'Deals melee bash damage to one target. Attempts to inflict leg bind on the target.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (447, 'Pugilist', 'One-Two Punch', 'Deals melee bash damage to one target. May follow up with Concussion, Arm Breaker, and Low Blow if the target does not have the respective bind. Follow-up skills deal reduced damage.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (448, 'Pugilist', 'Corkscrew', 'Deals melee bash damage to one target. Attempts to inflict paralysis on the target.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (449, 'Pugilist', 'Adrenaline', 'Restores TP to the user when they inflict a bind, ailment or stun. Inflicting something on multiple enemies will not increase the effect of this skill.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (450, 'Pugilist', 'Double Punch', 'When any single-action, single-target Pugilist skill is used, or when Corkscrew is used via Added Blow, or when Cross Counter is used (despite what the description claims), if the skill fails to inflict their bind or ailment, there is a chance it will be repeated.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (451, 'Pugilist', 'Chop', 'Occasionally gains more items when using Chop points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (452, 'Pugilist', 'HP Up', 'Increases maximum HP.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (453, 'Pugilist', 'Devil''s Fist', 'Consumes HP to deal melee bash damage to one target, with splash damage.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (454, 'Pugilist', 'Fighting Spirit', 'If the user lost HP on the previous turn, increases their attack this turn.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (455, 'Pugilist', 'Following Strike', 'When the user inflicts a bind on an enemy, there is a chance to follow up with Corkscrew.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (456, 'Pugilist', 'Leading Blow', 'Deals melee bash damage to one target. For every bind the target has, follows up with the corresponding Pugilist skill. For any ailment the target has, follows up with Corkscrew.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (457, 'Pugilist', 'Breather', 'Removes binds and ailment from the user, and increases attack until the end of the next turn. Cannot be used if the user has no binds or ailments.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (458, 'Pugilist', 'Fault Blocker', 'For 3 turns, increases ailment and bind resistance for the user''s row.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (459, 'Pugilist', 'Clinch', 'Attempts to inflict head bind, arm bind, and leg bind on both the user and the target.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (460, 'Pugilist', 'Status ATK Up', 'Increases the chance of inflicting binds and ailments.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (461, 'Pugilist', 'Cross Counter', 'This turn, when a party member on the user''s row is attacked, counterattacks with melee bash damage and attempts to inflict the corresponding bind on the target. Does not activate if the counterattack cannot reach the enemy.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (462, 'Pugilist', 'Thunder Fist', 'Deals melee bash+volt damage to one target. If the attack does not kill the target, the user takes damage.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (463, 'Pugilist', 'Lash Out', 'Deals multiple instances of melee bash damage to one target. The number of hits is equal to the number of hits made on the previous turn. No matter how many attacks Lash Out makes, it will always count as 1 attack for the purpose of this skill.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (464, 'Pugilist', 'Meditation', 'Until the end of the next turn, increases user''s chance of inflicting binds and ailments.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (465, 'Pugilist', 'Raging Billows', 'Increases damage dealt based on the number of binds and ailments the target has.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (466, 'Pugilist', 'Million Rush', 'Normal attacks may hit 2-4 times if two weapons are equipped. Enables sub-weapon when this skill is learned.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (467, 'Pugilist', 'Resonance Blow', 'Deals multiple instances of melee bash damage to one target. The number of hits increases based on the number of turns since Resonance Blow was last used.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (468, 'Harbinger', 'Endless Armor', 'For 3 turns, Miasma Armor''s duration will not decrease, and it cannot be removed.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (469, 'Harbinger', 'Miasma Tsunami', 'This turn, greatly reduces all enemies'' attack, defense, evasion, action speed, and bind/ailment resistance.', 0);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (470, 'Harbinger', 'Eroding Miasma', 'For a set number of turns, decreases all enemies'' defense.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (471, 'Harbinger', 'Stifling Miasma', 'For a set number of turns, decreases all enemies'' attack.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (472, 'Harbinger', 'Sluggish Miasma', 'For a set number of turns, decreases all enemies'' evasion and action speed.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (473, 'Harbinger', 'Paralyzing Reap', 'Deals melee cut damage to one row. If Miasma Armor is active, attempts to inflict paralysis.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (474, 'Harbinger', 'Toxic Reap', 'Deals melee cut damage to one row. If Miasma Armor is active, attempts to inflict poison.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (475, 'Harbinger', 'Miasma Armor', 'Puts the user in the Miasma Armor state for 3 turns. Increases action speed when Miasma Armor is active. At the start of battle, automatically puts the user in the Miasma Armor state.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (476, 'Harbinger', 'Endless Shroud', 'When the user uses a debuff skill, there''s a chance to cast Miasma Armor automatically.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (477, 'Harbinger', 'Atonement', 'Requires Miasma Armor. Removes Miasma Armor to restore HP to all party members and attempt to remove their ailments.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (478, 'Harbinger', 'Take', 'Occasionally gains more items when using Take points.', 1);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (479, 'Harbinger', 'Wilting Miasma', 'For a set number of turns, decreases all enemies'' resistance to and rate of recovery from ailments.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (480, 'Harbinger', 'Binding Miasma', 'For a set number of turns, decreases all enemies'' resistance to and rate of recovery from binds.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (481, 'Harbinger', 'Darkness Reap', 'Deals melee cut damage to one row. If Miasma Armor is active, attempts to inflict blind.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (482, 'Harbinger', 'Chaos Reap', 'Deals melee cut damage to one row. If Miasma Armor is active, attempts to inflict panic.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (483, 'Harbinger', 'Black Shroud', 'During Miasma Armor, increases defense.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (484, 'Harbinger', 'Soul Transfer', 'Requires Miasma Armor. Removes Miasma Armor to attempt to revive all party members.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (485, 'Harbinger', 'Black Wave', 'At the end of the turn, if Miasma Armor is active, restores TP to the user.', 4);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (486, 'Harbinger', 'Spirit Absorb', 'When the user uses a debuff skill, restores HP to the user. This restoration can heal beyond maximum HP. Overhealed HP will disappear at the end of the turn.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (487, 'Harbinger', 'Status ATK Up', 'Increases the chance of inflicting binds and ailments.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (488, 'Harbinger', 'Death Tolerance', 'Provides a chance to nullify debuffs and ailments on the user as they are inflicted.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (489, 'Harbinger', 'Ephemeral Reap', 'Deals multiple instances of melee cut damage to one target. Number of hits increases based on the number of debuffs on the target.', 10);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (490, 'Harbinger', 'Fatal Reap', 'Deals melee cut damage to one target. Attempts to inflict instant death.', 8);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (491, 'Harbinger', 'Miasma Wall', 'Requires Miasma Armor. Removes Miasma Armor to attempt to nullify binds and ailments against all party members, up to a set number of times.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (492, 'Harbinger', 'Spirit Barrier', 'Requires Miasma Armor. Removes Miasma Armor to attempt to nullify instant death, stun and debuffs against all party members, up to a set number of times.', 6);
INSERT INTO skill_infos (id, role, name, description, max_level)
    VALUES (493, 'Harbinger', 'Enduring Armor', 'Skills which remove Miasma Armor will instead reduce its duration by a set number of turns. If Miasma Armor''s duration reaches 0 or less, it is removed.', 4);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (1, 0, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (3, 2, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (5, 4, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (7, 6, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (11, 3, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (12, 11, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (13, 5, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (14, 13, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (15, 7, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (16, 15, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (17, 8, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (18, 9, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (20, 12, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (21, 14, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (22, 21, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (24, 23, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (25, 17, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (27, 26, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (29, 28, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (31, 30, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (34, 33, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (37, 29, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (38, 31, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (39, 32, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (47, 37, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (48, 38, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (49, 48, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (50, 39, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (51, 43, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (51, 44, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (51, 45, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (53, 52, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (55, 54, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (63, 55, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (64, 57, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (65, 64, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (66, 59, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (67, 66, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (68, 61, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (69, 68, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (72, 63, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (73, 63, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (76, 69, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (77, 76, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (79, 78, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (81, 80, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (83, 82, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (85, 84, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (87, 86, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (89, 81, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (90, 89, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (91, 81, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (92, 91, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (93, 83, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (94, 85, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (97, 382, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (98, 90, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (99, 92, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (100, 93, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (310, 94, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (105, 104, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (107, 106, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (109, 108, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (111, 110, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (116, 107, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (117, 116, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (118, 109, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (119, 118, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (120, 111, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (121, 120, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (122, 112, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (122, 113, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (124, 117, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (125, 119, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (126, 121, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (128, 127, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (131, 130, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (133, 132, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (135, 134, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (136, 134, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (141, 133, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (142, 141, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (143, 141, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (144, 135, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (145, 136, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (146, 144, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (146, 145, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (147, 138, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (150, 142, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (150, 143, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (151, 150, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (152, 146, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (153, 147, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (154, 153, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (157, 156, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (159, 158, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (161, 160, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (162, 160, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (167, 159, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (168, 161, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (170, 162, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (171, 163, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (172, 171, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (173, 164, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (174, 173, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (176, 167, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (177, 169, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (178, 170, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (179, 178, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (180, 174, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (183, 182, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (185, 184, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (187, 186, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (189, 188, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (193, 185, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (194, 193, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (195, 187, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (197, 196, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (198, 189, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (199, 191, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (202, 194, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (203, 197, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (204, 197, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (205, 197, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (209, 208, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (211, 210, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (212, 210, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (213, 210, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (215, 214, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (217, 216, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (222, 211, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (222, 212, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (222, 213, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (223, 215, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (224, 215, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (225, 223, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (225, 224, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (229, 222, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (231, 225, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (232, 226, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (232, 227, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (233, 232, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (235, 234, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (237, 236, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (239, 238, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (241, 240, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (245, 237, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (246, 239, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (247, 246, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (249, 248, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (250, 241, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (252, 242, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (254, 245, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (255, 254, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (256, 247, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (257, 256, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (257, 249, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (258, 251, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (261, 260, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (263, 262, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (264, 262, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (265, 262, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (267, 266, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (268, 266, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (273, 263, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (274, 264, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (275, 265, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (276, 267, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (277, 276, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (278, 268, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (279, 278, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (280, 273, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (281, 274, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (282, 275, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (283, 280, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (283, 281, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (283, 282, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (284, 277, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (285, 270, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (285, 279, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (287, 286, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (289, 288, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (290, 288, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (292, 291, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (297, 289, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (297, 290, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (298, 297, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (300, 292, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (301, 293, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (302, 301, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (305, 296, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (306, 298, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (307, 306, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (308, 299, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (310, 305, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (311, 310, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (313, 312, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (315, 314, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (320, 319, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (323, 315, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (324, 316, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (325, 324, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (326, 317, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (327, 318, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (328, 327, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (332, 323, 4);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (333, 325, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (334, 333, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (335, 328, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (336, 335, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (337, 329, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (339, 338, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (349, 341, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (350, 349, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (351, 349, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (352, 342, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (352, 343, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (352, 344, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (353, 352, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (354, 346, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (355, 354, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (358, 350, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (359, 351, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (360, 353, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (361, 360, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (362, 355, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (365, 364, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (367, 366, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (369, 368, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (375, 367, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (376, 375, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (377, 367, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (378, 369, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (379, 378, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (380, 399, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (381, 380, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (384, 376, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (385, 377, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (386, 379, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (387, 386, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (388, 373, 4);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (389, 383, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (391, 390, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (393, 392, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (395, 394, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (397, 396, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (401, 393, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (402, 401, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (403, 395, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (404, 397, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (406, 405, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (410, 402, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (411, 410, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (412, 404, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (413, 404, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (414, 412, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (414, 413, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (417, 416, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (420, 418, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (420, 419, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (423, 422, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (424, 422, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (427, 420, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (428, 427, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (429, 420, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (430, 429, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (431, 423, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (431, 424, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (432, 431, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (433, 431, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (434, 431, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (436, 428, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (437, 430, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (439, 432, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (439, 433, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (439, 434, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (443, 442, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (447, 444, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (447, 445, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (447, 446, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (454, 453, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (455, 447, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (455, 448, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (456, 455, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (459, 457, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (459, 458, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (462, 454, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (463, 456, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (464, 459, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (465, 464, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (467, 466, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (469, 468, 0);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (472, 470, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (472, 471, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (474, 473, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (476, 475, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (477, 475, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (479, 472, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (480, 479, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (481, 474, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (482, 481, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (483, 476, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (484, 477, 3);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (485, 484, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (490, 482, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (491, 485, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (492, 485, 1);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (493, 491, 2);
INSERT INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level)
    VALUES (493, 492, 2);
