package com.definitelyNOTdilophosaurus.dinosauria.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.extensibility.IActivityContext;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class DilophosaurusEntity extends Animal implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public DilophosaurusEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.5f)
                .add(Attributes.ATTACK_SPEED, 2.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.5f).build();
    }

    public void setStanding(boolean pStanding) {
        this.playSound(SoundEvents.PANDA_STEP, 0.15F, 1.0F);
    }

    class DilophosaurusEntityMeleeAttackGoal extends MeleeAttackGoal {
        public DilophosaurusEntityMeleeAttackGoal() {
            super(DilophosaurusEntity.this, 1.25D, true);
        }

        protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
            double d0 = this.getAttackReachSqr(pEnemy);
            if (pDistToEnemySqr <= d0 && this.isTimeToAttack()) {
                this.resetAttackCooldown();
                this.mob.doHurtTarget(pEnemy);
                DilophosaurusEntity.this.setStanding(false);
            } else if (pDistToEnemySqr <= d0 * 2.0D) {
                if (this.isTimeToAttack()) {
                    DilophosaurusEntity.this.setStanding(false);
                    this.resetAttackCooldown();
                }

                if (this.getTicksUntilNextAttack() <= 10) {
                    DilophosaurusEntity.this.setStanding(true);

                }
            } else {
                this.resetAttackCooldown();
                DilophosaurusEntity.this.setStanding(false);
            }

        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void stop() {
            DilophosaurusEntity.this.setStanding(false);
            super.stop();
        }

        protected double getAttackReachSqr(LivingEntity pAttackTarget) {
            return (double)(4.0F + pAttackTarget.getBbWidth());
        }
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new DilophosaurusEntity.DilophosaurusEntityMeleeAttackGoal());
        // this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        // this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(6, (new HurtByTargetGoal(this)).setAlertOthers());
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.PANDA_STEP, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.PARROT_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.DOLPHIN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.DOLPHIN_DEATH;
    }

    protected float getSoundVolume() {
        return 0.2F;
    }


    //ANIMATIONS

    @Override
    public void registerControllers(AnimationData data) {

    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
